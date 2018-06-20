package com.maocanmao.mypass.mvp.model

import android.util.Log
import com.maocanmao.mypass.appinfra.IRepositoryManager
import com.maocanmao.mypass.di.scope.UIScope
import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.contract.AccountContract
import io.reactivex.Flowable
import io.realm.Realm
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
        return mRepositoryManager.obtainDataBaseService(Realm::class.java)
                .where(Account::class.java).findAllAsync().asFlowable()

    }


    override fun insertAccount(account: Account) {
//        mRepositoryManager.obtainDataBaseService(Realm::class.java).beginTransaction()
//        mRepositoryManager.obtainDataBaseService(Realm::class.java).insert(account)
//        mRepositoryManager.obtainDataBaseService(Realm::class.java).commitTransaction()
        mRepositoryManager.obtainDataBaseService(Realm::class.java).executeTransactionAsync(Realm.Transaction { bgRealm->
            bgRealm.insert(account)
        },Realm.Transaction.OnSuccess {
            Log.i("TAG","insert success")
        },
        Realm.Transaction.OnError { error->
            Log.i("TAG","insert error"+error.message)
        })

    }

}