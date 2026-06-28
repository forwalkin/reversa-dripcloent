//FFLOADER.JAVA

package com.dts.Wreefiremax;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: /tmp/decompiler/261309cd6a8f497bbd4c575abae56d8d/classes.dex */
public class FFLoader extends Application implements Application.ActivityLifecycleCallbacks {
    boolean isRunning = false;

    private native void nativeInit(Context context, int i, Object obj);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    static {
        System.loadLibrary("shared");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        nativeInit(context, 0, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        nativeInit(activity, 1, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.isRunning) {
            return;
        }
        nativeInit(activity, 2, null);
        nativeInit(activity, 3, new CvsView(activity));
        nativeInit(activity, 3, new MenuView(activity));
        this.isRunning = true;
    }
}
