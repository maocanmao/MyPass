package com.maocanmao.mypass.model.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Account(@PrimaryKey var id: String?= UUID.randomUUID().toString(), var accountName: String?="", var password: String?="", var title: String?="") : RealmObject()