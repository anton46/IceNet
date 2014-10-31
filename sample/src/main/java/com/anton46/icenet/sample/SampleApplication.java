package com.anton46.icenet.sample;

import android.app.Application;

import labs.anton.icenet.IceNet;
import labs.anton.icenet.IceNetConfig;

/**
 * Created by anton on 10/31/14.
 */
public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        icenetConfig();
    }

    private void icenetConfig() {
        IceNetConfig config = new IceNetConfig.Builder()
                                            .setBaseUrl("http://private-f942-icenetsample.apiary-mock.com")
                                            .setContext(getApplicationContext())
                                            .build();

        IceNet.init(config);
    }
}
