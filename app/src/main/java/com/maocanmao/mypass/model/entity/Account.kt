package com.maocanmao.mypass.model.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Account(@PrimaryKey var id: Long?=null, var accountName: String?="", var password: String?="", var title: String?="") : RealmObject()