package com.maocanmao.mypass.appinfra

import android.app.Application



/**
 * Created by zhouyang on 2018/6/14.
 */
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        this.registerActivityLifecycleCallbacks(ActivityLifeCycle())
    }
}

