package com.capacitorjs.plugins.paxstore;

import android.os.RemoteException;

import androidx.appcompat.app.AppCompatActivity;

import com.pax.market.android.app.sdk.BaseApiService;
import com.pax.market.android.app.sdk.StoreSdk;

public class PaxstoreSdk {

    private final AppCompatActivity activity;

    PaxstoreSdk(AppCompatActivity activity) {
        this.activity = activity;
    }

    public String echo(String value) {
        return value;
    }

    public void init(String appkey, String appSecret) {
        StoreSdk.getInstance().init(this.activity, appkey, appSecret, new BaseApiService.Callback() {
            @Override
            public void initSuccess() {
                //TODO Do your business here
            }

            @Override
            public void initFailed(RemoteException e) {
                //TODO Do failed logic here
            }
        });
    }
}
