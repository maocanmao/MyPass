package com.maocanmao.mypass.appinfra

import android.content.Context
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by zhouyang on 2018/6/15.
 */
class RealmManager : IRepositoryManager {

    var context: Context

    @Inject
    constructor(context: Context) {
        this.context = context
    }


    override fun <T> obtainDataBaseService(dataBaseService: Class<T>): T {
        return when (dataBaseService) {
            Realm::class.java -> {
                Realm.init(context)
                Realm.getDefaultInstance() as T
            }
            else -> null as T
        }

    }

    override fun obtainRealmService(): Realm {
        return Realm.getDefaultInstance()
    }
}