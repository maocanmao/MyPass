package com.maocanmao.mypass.di.module

import android.content.Context
import com.maocanmao.mypass.appinfra.AppManager
import com.maocanmao.mypass.appinfra.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by zhouyang on 2018/6/14.
 */
@Module
class AppModule(private val app: BaseApp) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context = app.applicationContext

    @Singleton
    @Provides
    fun provideAppManager():AppManager= AppManager()

}