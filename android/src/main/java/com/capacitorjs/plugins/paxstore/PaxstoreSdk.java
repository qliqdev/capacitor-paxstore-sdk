package com.capacitorjs.plugins.paxstore;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.pax.unifiedsdk_psp_3rd_app.factory.ITransAPI;
import com.pax.unifiedsdk_psp_3rd_app.factory.TransAPIFactory;
import com.pax.unifiedsdk_psp_3rd_app.message.PurchaseMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.RefundMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.ReprintTotalMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.ReprintTransMsg;
import com.pax.unifiedsdk_psp_3rd_app.message.UniReversalMsg;
import com.pax.unifiedsdk_psp_3rd_app.sdkconstants.SdkConstants;

import java.util.Set;

public class PaxstoreSdk extends Printer {

    public ITransAPI transAPI = TransAPIFactory.createTransAPI();

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

    public void checkInit(PluginCall call) {
        if (configs.getAppKey() == null || configs.getAppSecret() == null || configs.getPackageName() == null) {
            call.reject("Not initialized");
            return;
        }

        try {
            JSObject ret = new JSObject();
            ret.put("isInitialized", true);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }

    public void startSale(PluginCall call, Context context) {
        String amount = call.getString("amount");
        if (amount == null) {
            call.reject("Must provide amount");
            return;
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
    }

    public void startReversal(PluginCall call, Context context) {
        String origRRN = call.getString("rrn");
        if (origRRN == null) {
            call.reject("please input original RRN");
            return;
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
    }

    public void startRefund(PluginCall call, Context context) {
        String origRRN = call.getString("rrn");
        String amount = call.getString("amount");
        if (origRRN == null) {
            call.reject("Must provide original RRN");
            return;
        }

        if (amount == null) {
            call.reject("Must provide amount");
            return;
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
    }

    public void startPrintTrans(PluginCall call, Context context) {
        String voucherNo = call.getString("etVoucherNo");
        if (voucherNo == null) {
            call.reject("Must provide voucherNo");
            return;
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
    }

    public void startPrintTransTotal(PluginCall call, Context context) {
        String type = call.getString("etPrintType");
        if (type == null) {
            call.reject("Must provide etPrintType");
            return;
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
    }

    public void findPrinters(PluginCall call) {
        Set<BluetoothDevice> printers = findBT(call);
        if (!printers.isEmpty()) {
            JSArray printerArr = new JSArray();
            for (BluetoothDevice device : printers) {
                JSObject deviceObj = new JSObject();
                deviceObj.put("address", device.getAddress());
                deviceObj.put("name", device.getName());
                deviceObj.put("class", device.getBluetoothClass());
                printerArr.put(deviceObj);
            }
            JSObject ret = new JSObject();
            ret.put("printers", printerArr);
            call.resolve(ret);
        } else {
            call.reject("No printers found");
        }
    }

    public void setPrinter(PluginCall call) {
        String address = call.getString("address");
        try {
            setBT(address);
            JSObject ret = new JSObject();
            ret.put("success", true);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject("Printer didn't initialized");
            e.printStackTrace();
        }

    }

    public void printBill(PluginCall call) {
        String value = call.getString("value");
        if (value == null) {
            call.reject("Must provide value");
            return;
        }

        try {
            openBT();
            printTxt(value);
            closeBT();

            JSObject ret = new JSObject();
            ret.put("success", true);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
            e.printStackTrace();
        }
    }
}
