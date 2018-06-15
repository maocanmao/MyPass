package com.maocanmao.mypass.model.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

data class Account(@PrimaryKey val id: String, val accountName: String, val password: String, val title: String) : RealmObject()