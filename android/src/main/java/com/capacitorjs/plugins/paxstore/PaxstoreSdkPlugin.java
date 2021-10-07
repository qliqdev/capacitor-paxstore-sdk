package com.capacitorjs.plugins.paxstore;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "PaxstoreSdk")

public class PaxstoreSdkPlugin extends Plugin {

    private PaxstoreSdk implementation;

    @Override
    public void load() {
        implementation = new PaxstoreSdk(getActivity());
    }

    @PluginMethod
    private void echo(PluginCall call) {
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
    private void init(PluginCall call) {
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
            implementation.init(appKey, appSecret);
            call.resolve();
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }
}
