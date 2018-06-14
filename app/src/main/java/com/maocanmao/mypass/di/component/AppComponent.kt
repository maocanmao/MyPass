package com.maocanmao.mypass.di.component

import com.maocanmao.mypass.appinfra.ActivityLifeCycle
import com.maocanmao.mypass.appinfra.BaseApp
import com.maocanmao.mypass.di.module.AppModule
import com.maocanmao.mypass.ui.activity.MainActivity
import com.maocanmao.mypass.ui.activity.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by zhouyang on 2018/6/14.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(baseApp: BaseApp)
    fun inject(mainActivity: MainActivity)
    fun inject(splashActivity: SplashActivity)
    fun inject(activityLifeCycle: ActivityLifeCycle)
}