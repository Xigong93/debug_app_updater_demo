package com.pokercc.app_debug_updater_demo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.pokercc.contract.IDebugComponent;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        IDebugComponent debugComponent = ARouter.getInstance().navigation(IDebugComponent.class);
        if (debugComponent != null) {
            debugComponent.onAppCreate(this);
        }
    }
}
