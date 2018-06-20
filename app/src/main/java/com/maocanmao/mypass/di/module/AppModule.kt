package com.maocanmao.mypass.di.module

import android.content.Context
import com.maocanmao.mypass.appinfra.AppManager
import com.maocanmao.mypass.appinfra.IRepositoryManager
import com.maocanmao.mypass.appinfra.RealmManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by zhouyang on 2018/6/14.
 */
@Module
class AppModule(private val app: Context) {


    @Singleton
    @Provides
    fun provideApplicationContext():Context = app.applicationContext

    @Singleton
    @Provides
    fun provideAppManager():AppManager= AppManager()

    @Singleton
    @Provides
    fun provideRepositoryManager():IRepositoryManager= RealmManager(app)


}