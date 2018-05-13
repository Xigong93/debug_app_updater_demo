package com.pokercc.app_debug_updater_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.pokercc.contract.IDebugComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IDebugComponent debugComponent = ARouter.getInstance().navigation(IDebugComponent.class);
        if (debugComponent != null) {
            debugComponent.onMainPageCreate(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        IDebugComponent debugComponent = ARouter.getInstance().navigation(IDebugComponent.class);
        if (debugComponent != null) {
            debugComponent.onMainPageDestroy(this);
        }
    }
}
