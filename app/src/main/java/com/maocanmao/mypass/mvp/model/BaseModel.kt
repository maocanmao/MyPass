package com.maocanmao.mypass.mvp.model

import com.maocanmao.mypass.appinfra.IRepositoryManager
import javax.inject.Inject

/**
 * Created by zhouyang on 2018/6/15.
 */
class BaseModel(
        var mRepositoryManager: IRepositoryManager) : IModel {

}