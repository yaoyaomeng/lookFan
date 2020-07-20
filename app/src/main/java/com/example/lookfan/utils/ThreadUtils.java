package com.example.lookfan.utils;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils {
     private static Handler handler = new Handler(Looper.getMainLooper());

    public static void onMainThread(Runnable r) {
        handler.post(r);
    }
}
