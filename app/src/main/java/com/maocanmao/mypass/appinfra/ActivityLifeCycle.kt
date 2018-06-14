package com.maocanmao.mypass.appinfra

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by zhouyang on 2018/6/14.
 */
class ActivityLifeCycle : Application.ActivityLifecycleCallbacks {
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {

        AppManager.addActivity(activity)
    }

    override fun onActivityDestroyed(activity: Activity) {
        AppManager.removeActivity(activity)
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle?) {

    }
}