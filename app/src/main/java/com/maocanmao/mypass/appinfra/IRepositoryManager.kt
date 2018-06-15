package com.maocanmao.mypass.appinfra

import android.content.Context

/**
 * Created by zhouyang on 2018/6/15.
 */
interface IRepositoryManager {
     fun <T> obtainDataBaseService(dataBaseService :Class<T>) : T
}