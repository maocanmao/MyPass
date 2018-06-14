package com.maocanmao.mypass.appinfra

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.maocanmao.mypass.di.component.AppComponent
import com.maocanmao.mypass.di.component.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by zhouyang on 2018/6/14.
 */
class ActivityLifeCycle : Application.ActivityLifecycleCallbacks {
    @Inject
    lateinit var appManager:AppManager

    init {
        BaseApp.appComponent.inject(this)
    }

    override fun onActivityStopped(activity: Activity) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {

        appManager.addActivity(activity)
    }

    override fun onActivityDestroyed(activity: Activity) {
        appManager.removeActivity(activity)
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle?) {

    }
}