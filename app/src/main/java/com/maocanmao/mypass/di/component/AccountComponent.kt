package com.maocanmao.mypass.di.component

import com.maocanmao.mypass.di.module.AccountModule
import com.maocanmao.mypass.di.scope.UIScope
import com.maocanmao.mypass.mvp.ui.activity.AddAccountActivity
import com.maocanmao.mypass.mvp.ui.activity.SplashActivity
import com.maocanmao.mypass.mvp.ui.fragment.HomeFragment
import dagger.Component

/**
 * Created by zhouyang on 2018/6/19.
 */
@UIScope
@Component(modules = [(AccountModule::class)],dependencies = [(AppComponent::class)])
interface AccountComponent{

    fun inject(splashActivity: SplashActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(addAccountActivity: AddAccountActivity)

}