package com.maocanmao.mypass.mvp.presenter

import com.maocanmao.mypass.mvp.contract.IView
import com.maocanmao.mypass.mvp.model.IModel

/**
 * Created by zhouyang on 2018/6/19.
 */
open class BasePresenter<M :IModel,V:IView>{
    protected var mModel: M? = null
    protected var mRootView: V? = null

    constructor(mModel: M?, mRootView: V?) {
        this.mModel = mModel
        this.mRootView = mRootView
    }

    constructor(mRootView: V?) {
        this.mRootView = mRootView
    }

}