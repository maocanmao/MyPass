package com.maocanmao.mypass.mvp.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
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

    private lateinit var accountDescription: String
    private lateinit var accountName: String
    private lateinit var accountPassword: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account)
        DaggerAccountComponent.builder().appComponent(BaseApp.appComponent)
                .accountModule(AccountModule(this)).build().inject(this)
        initUI()
    }

    private fun initUI() {
        toolbar.title = ""
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        toolbar.inflateMenu(R.menu.add_account_toolbar_menu)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun saveData() {
        accountDescription = account_description.text.toString()
        accountName = account_name.text.toString()
        accountPassword = account_password.text.toString()
        if (accountName.isEmpty() || accountPassword.isEmpty() || accountDescription.isEmpty()) {
            Snackbar.make(window.decorView, "请填写完整资料", Snackbar.LENGTH_SHORT).show()
            return
        }

        mPresenter.insertNewAccount(accountName, accountPassword, accountDescription)
        finish()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_account_toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_save -> {
            saveData()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }

    override fun showMessage(message: String) {
    }

    override fun onAccountsLoaded(accounts: List<Account>) {
    }

    override fun onAccountLoadFailed() {
    }


}
