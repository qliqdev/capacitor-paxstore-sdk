package com.capacitorjs.plugins.paxstore;

import static java.security.AccessController.getContext;

import android.app.Application;
import android.content.Context;
import android.os.RemoteException;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.pax.market.android.app.sdk.BaseApiService;
import com.pax.market.android.app.sdk.StoreSdk;
import com.pax.market.android.app.sdk.dto.TerminalInfo;
import com.pax.unifiedsdk_psp_3rd_app.factory.ITransAPI;
import com.pax.unifiedsdk_psp_3rd_app.message.BaseResponse;
import com.pax.unifiedsdk_psp_3rd_app.message.PurchaseMsg;
import com.pax.unifiedsdk_psp_3rd_app.sdkconstants.SdkConstants;

public class PaxstoreSdk {
    public String echo(String value) {
        return value;
    }

    public void init(Application activity, PluginCall call ) {
        String appKey = call.getString("appKey");
        String appSecret = call.getString("appSecret");
        if (appKey == null) {
            call.reject("Must provide appkey");
            return;
        }

        if (appSecret == null) {
            call.reject("Must provide appSecret");
            return;
        }
        try {
            StoreSdk.getInstance().init(activity, appKey, appSecret, new BaseApiService.Callback() {
                @Override
                public void initSuccess() {
                    //TODO Do your business here
                    JSObject ret = new JSObject();
                    ret.put("value", "Запуск");
                    call.resolve(ret);
                }

                @Override
                public void initFailed(RemoteException e) {
                    //TODO Do failed logic here
                    call.reject(e.toString());
                }
            });

        } catch (Exception e) {
            call.reject(e.getMessage());
        }

    }

    public boolean checkInit() {
        return StoreSdk.getInstance().checkInitialization();
    }

    public void getInfo(Application activity, PluginCall call ) {
        try {
            StoreSdk.getInstance().getBaseTerminalInfo(activity,new BaseApiService.ICallBack() {
                @Override
                public void onSuccess(Object obj) {
                    TerminalInfo terminalInfo = (TerminalInfo) obj;
                    JSObject ret = new JSObject();
                    ret.put("value", terminalInfo);
                    call.resolve(ret);
                }

                @Override
                public void onError(Exception e) {
                    call.reject(e.toString());
                }
            });

        } catch (Exception e) {
            call.reject(e.getMessage());
        }

    }

    public boolean startSale(PluginCall call, ITransAPI transAPI, Context context) {
        String amount = call.getString("amount");
        if (amount == null) {
            call.reject("Must provide appkey");
            return false;
        }

        try {
            PurchaseMsg.Request request = new PurchaseMsg.Request();
            request.setAmount(Long.parseLong(amount));
            request.setCategory(SdkConstants.CATEGORY_PURCHASE);
            request.setPackageName("com.pax.psp_3rd_app");
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
