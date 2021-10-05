package com.capacitorjs.plugins.paxstore;

import android.os.RemoteException;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.pax.market.android.app.sdk.BaseApiService;
import com.pax.market.android.app.sdk.StoreSdk;

@CapacitorPlugin(name = "PaxstoreSdk")
public class PaxstoreSdkPlugin extends Plugin {
    private PaxstoreSdk implementation = new PaxstoreSdk();

    @PluginMethod
    private void init(PluginCall call) {
        //todo Init AppKey，AppSecret, make sure the appKey and appSecret is corret.
        String appkey = call.getString("appkey");
        String appSecret = call.getString("appSecret");
        JSObject ret = new JSObject();

        StoreSdk.getInstance().init(getActivity().getApplicationContext(), appkey, appSecret, new BaseApiService.Callback() {
            @Override
            public void initSuccess() {
                //TODO Do your business here
//                ret.put("value", implementation.init());
                call.resolve(ret);
            }

            @Override
            public void initFailed(RemoteException e) {
                //TODO Do failed logic here
                call.reject("initFailed");
            }
        });
    }
}
