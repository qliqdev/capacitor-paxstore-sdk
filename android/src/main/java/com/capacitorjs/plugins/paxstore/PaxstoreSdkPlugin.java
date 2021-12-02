package com.capacitorjs.plugins.paxstore;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "PaxstoreSdk")
public class PaxstoreSdkPlugin extends Plugin {

    private final PaxstoreSdk implementation = new PaxstoreSdk();

    @PluginMethod
    public void init(PluginCall call) {
        implementation.init(getActivity().getApplication(), call);
    }

    @PluginMethod
    public void checkInit(PluginCall call) {
        implementation.checkInit(call);
    }

    @PluginMethod
    public void startSale(PluginCall call) {
        implementation.startSale(call, getContext());
    }

    @PluginMethod
    public void startReversal(PluginCall call) {
        implementation.startReversal(call, getContext());
    }

    @PluginMethod
    public void startRefund(PluginCall call) {
        implementation.startRefund(call, getContext());
    }

    @PluginMethod
    public void startPrintTrans(PluginCall call) {
        implementation.startPrintTrans(call, getContext());
    }

    @PluginMethod
    public void startPrintTransTotal(PluginCall call) {
        implementation.startPrintTransTotal(call, getContext());
    }

    @PluginMethod
    public void findPrinters(PluginCall call) {
        implementation.findPrinters(call);
    }

    @PluginMethod
    public void setPrinter(PluginCall call) {
        implementation.setPrinter(call);
    }

    @PluginMethod
    public void printBill(PluginCall call) {
        implementation.printBill(call);
    }

}
