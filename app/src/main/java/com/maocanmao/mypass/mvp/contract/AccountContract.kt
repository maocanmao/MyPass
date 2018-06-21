package com.maocanmao.mypass.mvp.contract

import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.model.IModel
import io.reactivex.Flowable
import io.realm.RealmResults

/**
 * Created by zhouyang on 2018/6/15.
 */
interface AccountContract {
    interface View : IView {
        fun onAccountsLoaded(accounts: List<Account>)
        fun onAccountLoadFailed()
    }

    interface Model : IModel {
        fun getAllAccount(): Flowable<RealmResults<Account>>
        fun insertAccount(account: Account)

    }
}