package com.maocanmao.mypass.appinfra

import android.content.Context
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by zhouyang on 2018/6/15.
 */
class RepositoryManager @Inject constructor() : IRepositoryManager {

    @Inject
    lateinit var context:Context

    override fun <T> obtainDataBaseService(dataBaseService: Class<T>): T {
        return when(dataBaseService){
            is Realm->{
                Realm.init(context)
                Realm.getDefaultInstance() as T
            }
            else -> null as T
        }

    }
}