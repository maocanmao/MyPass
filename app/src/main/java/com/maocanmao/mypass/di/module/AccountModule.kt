package com.maocanmao.mypass.di.module

import com.maocanmao.mypass.di.scope.UIScope
import com.maocanmao.mypass.mvp.contract.AccountContract
import com.maocanmao.mypass.mvp.model.AccountModel
import dagger.Module
import dagger.Provides

/**
 * Created by zhouyang on 2018/6/19.
 */
@Module
class AccountModule {
    var view: AccountContract.View

    constructor(view: AccountContract.View) {
        this.view = view
    }


    @Provides
    @UIScope
    fun provideAccountView(): AccountContract.View {
        return this.view
    }

    @Provides
    @UIScope
    fun provideAccountModel(model: AccountModel): AccountContract.Model {
        return model
    }


}