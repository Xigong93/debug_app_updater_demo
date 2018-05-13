package com.pokercc.contract;

import android.content.Context;
import android.support.annotation.NonNull;

public interface IDebugComponent {
    void onAppCreate(@NonNull Context context);

    void onMainPageCreate(@NonNull Context context);

    void onMainPageDestroy(@NonNull Context context);
}
