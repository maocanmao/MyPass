package com.maocanmao.mypass.mvp.model

import android.util.Log
import com.maocanmao.mypass.appinfra.IRepositoryManager
import com.maocanmao.mypass.di.scope.UIScope
import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.contract.AccountContract
import io.reactivex.Flowable
import io.realm.RealmResults
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
                .where(Account::class.java).findAllAsync().asFlowable()

    }


    override fun insertAccount(account: Account) {

        mRepositoryManager.obtainRealmService().executeTransactionAsync({ bgRealm ->
            bgRealm.copyToRealm(account)
        }, {
            Log.i("TAG", "insert success")
        },
                { error ->
                    Log.i("TAG", "insert error" + error.message)
                })

    }

}