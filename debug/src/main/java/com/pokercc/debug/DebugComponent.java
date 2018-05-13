package com.pokercc.debug;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.stetho.Stetho;
import com.pgyersdk.update.PgyUpdateManager;
import com.pokercc.contract.IDebugComponent;
import com.squareup.leakcanary.LeakCanary;

import java.util.concurrent.TimeUnit;

@Route(path = "/debug/debug_component", name = "测试组件")
public class DebugComponent implements IDebugComponent {

    private Handler pgyerUpdaterHandler;

    @Override
    public void onAppCreate(@NonNull Context context) {
        Stetho.initializeWithDefaults(context);
        LeakCanary.install((Application) context.getApplicationContext());

    }


    @Override
    public void onMainPageCreate(@NonNull final Context context) {
        // pgyer 检查测试版的更新更新
        if (pgyerUpdaterHandler != null) {
            pgyerUpdaterHandler.removeCallbacksAndMessages(null);
        }
        pgyerUpdaterHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // 不解除注册，有时候会出现两个更新提示框
                PgyUpdateManager.unregister();
                PgyUpdateManager.register((Activity) context);
                // 两分钟检查更新一次
                sendEmptyMessageDelayed(0, TimeUnit.MINUTES.toMillis(2));
                System.out.println("蒲公英检查更新了");
            }
        };
    }

    @Override
    public void onMainPageDestroy(@NonNull Context context) {
        if (pgyerUpdaterHandler != null) {
            pgyerUpdaterHandler.removeCallbacksAndMessages(null);
        }
    }
}
