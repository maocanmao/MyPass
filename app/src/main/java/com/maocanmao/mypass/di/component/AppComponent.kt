package com.maocanmao.mypass.di.component

import android.content.Context
import com.maocanmao.mypass.appinfra.*
import com.maocanmao.mypass.di.module.AppModule
import com.maocanmao.mypass.mvp.ui.activity.MainActivity
import com.maocanmao.mypass.mvp.ui.activity.SplashActivity
import com.maocanmao.mypass.mvp.ui.fragment.HomeFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by zhouyang on 2018/6/14.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(baseApp: BaseApp)
    fun inject(activityLifeCycle: ActivityLifeCycle)
    fun inject(mainActivity: MainActivity)
    fun inject(repositoryManager: IRepositoryManager)

    fun repositoryManager():IRepositoryManager
    fun context():Context
    fun appManager():AppManager
}