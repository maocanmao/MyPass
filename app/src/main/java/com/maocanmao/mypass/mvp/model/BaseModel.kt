package com.maocanmao.mypass.mvp.model

import com.maocanmao.mypass.appinfra.IRepositoryManager
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by zhouyang on 2018/6/15.
 */
open class BaseModel : IModel {

    var mRepositoryManager: IRepositoryManager

    constructor(repositoryManager: IRepositoryManager) {
        this.mRepositoryManager = repositoryManager
    }


    override fun onDestroy() {

    }

}