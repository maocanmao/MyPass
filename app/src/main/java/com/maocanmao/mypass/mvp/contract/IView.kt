package com.maocanmao.mypass.mvp.contract

import android.app.Activity
import android.content.Intent

/**
 * Created by zhouyang on 2018/6/19.
 */
interface IView {

    fun showLoading() {

    }

    fun hideLoading() {

    }

    fun showMessage(message: String)

}