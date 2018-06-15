package com.maocanmao.mypass.mvp

import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.model.IModel
import io.reactivex.Observable

/**
 * Created by zhouyang on 2018/6/15.
 */
interface AccountContract {
    interface view{}

    interface Model :IModel{
        fun getAllAccount():Observable<List<Account>>

    }
}