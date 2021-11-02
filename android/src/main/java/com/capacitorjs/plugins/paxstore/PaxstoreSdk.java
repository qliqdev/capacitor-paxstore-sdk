package com.capacitorjs.plugins.paxstore;

import android.app.Application;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.pax.unifiedsdk_psp_3rd_app.factory.ITransAPI;
import com.pax.unifiedsdk_psp_3rd_app.message.PurchaseMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.RefundMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.ReprintTotalMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.ReprintTransMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.UniReversalMsg;
import com.pax.unifiedsdk_psp_3rd_app.sdkconstants.SdkConstants;

public class PaxstoreSdk {

    static class PaxConfigs {
        private String appKey;
        private String appSecret;
        private String packageName;

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }
    }

    PaxConfigs configs = new PaxConfigs();

    public String echo(String value) {
        return value;
    }

    public void init(Application activity, PluginCall call) {
        String appKey = call.getString("appKey");
        String appSecret = call.getString("appSecret");
        String packageName = call.getString("packageName");
        if (appKey == null) {
            call.reject("Must provide appkey");
            return;
        }

        if (appSecret == null) {
            call.reject("Must provide appSecret");
            return;
        }

        if (packageName == null) {
            call.reject("Must provide packageName");
            return;
        }

        try {
            configs.setAppKey(appKey);
            configs.setAppSecret(appSecret);
            configs.setPackageName(packageName);

            JSObject ret = new JSObject();
            ret.put("value", true);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }

    }

    public boolean checkInit(PluginCall call) {
        if(configs.getAppKey() == null || configs.getAppSecret() == null || configs.getPackageName() == null){
            call.reject("Not initialized");
            return false;
        }

        try {
            JSObject ret = new JSObject();
            ret.put("isInitialized", true);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
        return true;
    }

    public boolean startSale(PluginCall call, ITransAPI transAPI, Context context) {
        String amount = call.getString("amount");
        if (amount == null) {
            call.reject("Must provide amount");
            return false;
        }

        try {
            PurchaseMsg.Request request = new PurchaseMsg.Request();
            request.setAmount(Long.parseLong(amount));
            request.setCategory(SdkConstants.CATEGORY_PURCHASE);
            request.setPackageName(configs.getPackageName());
            request.setAppId(configs.getAppKey());
            Boolean response = transAPI.startTrans(context, request);
            JSObject ret = new JSObject();
            ret.put("value", response);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
        return true;
    }

    public boolean startReversal(PluginCall call, ITransAPI transAPI, Context context) {
        String origRRN = call.getString("rrn");
        if (origRRN == null) {
            call.reject("please input original RRN");
            return false;
        }

        try {
            UniReversalMsg.Request request = new UniReversalMsg.Request();
            request.setOrgRefNo(origRRN);
            request.setCategory(SdkConstants.CATEGORY_UNI_REVERSAL);
            request.setPackageName(configs.getPackageName());
            request.setAppId(configs.getAppKey());
            Boolean response = transAPI.startTrans(context, request);
            JSObject ret = new JSObject();
            ret.put("value", response);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
        return true;
    }

    public boolean startRefund(PluginCall call, ITransAPI transAPI, Context context) {
        String origRRN = call.getString("rrn");
        String amount = call.getString("amount");
        if (origRRN == null) {
            call.reject("Must provide original RRN");
            return false;
        }

        if (amount == null) {
            call.reject("Must provide amount");
            return false;
        }

        try {
            RefundMsg.Request request = new RefundMsg.Request();
            request.setAmount(TextUtils.isEmpty(amount) ? 0 : Long.parseLong(amount));
            request.setOrgRefNo(origRRN);
            request.setCategory(SdkConstants.CATEGORY_REFUND);
            request.setAppId(configs.getAppKey());
            request.setPackageName(configs.getPackageName());
            Boolean response = transAPI.startTrans(context, request);
            JSObject ret = new JSObject();
            ret.put("value", response);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
        return true;
    }

    public boolean startPrintTrans(PluginCall call, ITransAPI transAPI, Context context) {
        String voucherNo = call.getString("etVoucherNo");
        if (voucherNo == null) {
            call.reject("Must provide voucherNo");
            return false;
        }

        try {
            ReprintTransMsg.Request request = new ReprintTransMsg.Request();
            request.setVoucherNo(Integer.parseInt(voucherNo));
            request.setCategory(SdkConstants.CATEGORY_PRINT_TRANS);
            request.setAppId(configs.getAppKey());
            request.setPackageName(configs.getPackageName());
            Boolean response = transAPI.startTrans(context, request);
            JSObject ret = new JSObject();
            ret.put("value", response);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
        return true;
    }

    public boolean startPrintTransTotal(PluginCall call, ITransAPI transAPI, Context context) {
        String type = call.getString("etPrintType");
        if (type == null) {
            call.reject("Must provide etPrintType");
            return false;
        }

        try {
            ReprintTotalMsg.Request request = new ReprintTotalMsg.Request();
            request.setReprintType(Integer.parseInt(type));
            request.setCategory(SdkConstants.CATEGORY_PRINT_TRANS_TOTAL);
            request.setAppId(configs.getAppKey());
            request.setPackageName(configs.getPackageName());
            Boolean response = transAPI.startTrans(context, request);
            JSObject ret = new JSObject();
            ret.put("value", response);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
        return true;
    }
}
