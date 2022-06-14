package com.example.testapi.dispatchers;

import android.os.Handler;
import android.os.Looper;

import com.example.testapi.CallBackActivity;

public class MainThreadDispatcher implements Dispatcher {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final CallBackActivity callBackActivity;

    public MainThreadDispatcher(CallBackActivity callBackActivity){
        this.callBackActivity = callBackActivity;
    }

    public void dispatch(String result) {
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            callBackActivity.display(result);
        } else {
            handler.post(() -> callBackActivity.display(result));
        }
    }
}
