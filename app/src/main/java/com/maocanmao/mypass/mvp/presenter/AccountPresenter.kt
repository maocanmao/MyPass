package com.maocanmao.mypass.mvp.presenter

import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.contract.AccountContract
import javax.inject.Inject

/**
 * Created by zhouyang on 2018/6/19.
 */
class AccountPresenter :BasePresenter<AccountContract.Model,AccountContract.View>{

    @Inject
    constructor(mModel: AccountContract.Model?, mRootView: AccountContract.View?) : super(mModel, mRootView)

    fun getAllAccount(){
        val account = Account(1L,"ZHIHU","123","ZHIHU")
//        mModel?.insertAccount(account)
        mModel?.getAllAccount()?.subscribe { result->
            print(result.first())
        }

    }
}