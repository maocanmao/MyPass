package com.maocanmao.mypass.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.maocanmao.mypass.R
import com.maocanmao.mypass.appinfra.BaseApp
import com.maocanmao.mypass.di.component.DaggerAccountComponent
import com.maocanmao.mypass.di.module.AccountModule
import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.contract.AccountContract
import com.maocanmao.mypass.mvp.presenter.AccountPresenter
import kotlinx.android.synthetic.main.activity_add_account.*
import javax.inject.Inject

class AddAccountActivity : AppCompatActivity(), AccountContract.View {

    @Inject
    lateinit var mPresenter: AccountPresenter

    lateinit var accountDesrciption: String
    lateinit var accountName: String
    lateinit var accountPassword: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account)
        DaggerAccountComponent.builder().appComponent(BaseApp.appComponent)
                .accountModule(AccountModule(this)).build().inject(this)
        save_account.setOnClickListener {
            saveData()

        }
    }

    private fun saveData() {
        accountDesrciption = account_description.text.toString()
        accountName = account_name.text.toString()
        accountPassword = account_password.text.toString()

        val account: Account = Account(accountName = accountName,
                password = accountPassword,
                title = accountDesrciption)
        mPresenter.insertNewAccount(account)

    }

    override fun showMessage(message: String) {
    }

    override fun onAccountsLoaded(accounts: List<Account>) {
    }

    override fun onAccountLoadFailed() {
    }


}
