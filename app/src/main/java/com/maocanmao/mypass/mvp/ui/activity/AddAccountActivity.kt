package com.maocanmao.mypass.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.maocanmao.mypass.R
import kotlinx.android.synthetic.main.activity_add_account.*

class AddAccountActivity : AppCompatActivity() {
    lateinit var accountDesrciption:String;
    lateinit var accountName:String;
    lateinit var accountPassword:String;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account)
        save_account.setOnClickListener {
            initData()

        }
    }

    fun initData(){
        accountDesrciption = account_description.text.toString()
        accountName = account_name.text.toString()
        accountPassword = account_password.text.toString()
    }


}
