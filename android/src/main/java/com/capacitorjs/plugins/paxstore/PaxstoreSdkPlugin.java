package com.capacitorjs.plugins.paxstore;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.pax.unifiedsdk_psp_3rd_app.factory.ITransAPI;
import com.pax.unifiedsdk_psp_3rd_app.factory.TransAPIFactory;
import com.pax.unifiedsdk_psp_3rd_app.message.BaseResponse;

@CapacitorPlugin(name = "PaxstoreSdk")
public class PaxstoreSdkPlugin extends Plugin {

    public ITransAPI transAPI = TransAPIFactory.createTransAPI();
    private BaseResponse baseResponse;

    private final PaxstoreSdk implementation = new PaxstoreSdk();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        try {
            JSObject ret = new JSObject();
            ret.put("value", implementation.echo(value));
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }

    @PluginMethod
    public void init(PluginCall call) {
        implementation.init(getActivity().getApplication(), call);
    }

    @PluginMethod
    public void checkInit(PluginCall call) {
        try {
            JSObject ret = new JSObject();
            ret.put("isInitialized", implementation.checkInit());
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }

    @PluginMethod
    public void getInfo(PluginCall call) {
        implementation.getInfo(getActivity().getApplication(), call);
    }

    @PluginMethod
    public void startSale(PluginCall call) {
        implementation.startSale(call, transAPI, getContext());
    }

}
