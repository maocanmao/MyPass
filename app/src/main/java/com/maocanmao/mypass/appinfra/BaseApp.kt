package com.maocanmao.mypass.appinfra

import android.app.Application
import com.maocanmao.mypass.di.component.AppComponent
import com.maocanmao.mypass.di.component.DaggerAppComponent
import com.maocanmao.mypass.di.module.AppModule
import io.realm.Realm


/**
 * Created by zhouyang on 2018/6/14.
 */
class BaseApp : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        initDagger()
        Realm.init(this)
        this.registerActivityLifecycleCallbacks(ActivityLifeCycle())
    }

    private fun initDagger(){
        appComponent =  DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

}

