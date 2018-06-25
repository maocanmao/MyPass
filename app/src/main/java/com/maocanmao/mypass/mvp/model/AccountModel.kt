package com.maocanmao.mypass.mvp.model

import com.maocanmao.mypass.appinfra.IRepositoryManager
import com.maocanmao.mypass.di.scope.UIScope
import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.contract.AccountContract
import io.reactivex.Flowable
import io.realm.RealmResults
import io.realm.kotlin.where
import javax.inject.Inject


/**
 * Created by zhouyang on 2018/6/19.
 */
@UIScope
class AccountModel : BaseModel, AccountContract.Model {

    @Inject
    constructor(mRepositoryManager: IRepositoryManager) : super(mRepositoryManager)


    override fun getAllAccount(): Flowable<RealmResults<Account>> {
        return mRepositoryManager.obtainRealmService()
                .where<Account>().findAll().asFlowable()

    }


    override fun insertAccount(account: Account) {
//use sync function
        mRepositoryManager.obtainRealmService().executeTransaction({ bgRealm ->
            bgRealm.copyToRealm(account)
        })
    }

}