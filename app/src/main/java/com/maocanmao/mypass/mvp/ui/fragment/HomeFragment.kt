package com.maocanmao.mypass.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maocanmao.mypass.R
import com.maocanmao.mypass.appinfra.BaseApp
import com.maocanmao.mypass.di.component.DaggerAccountComponent
import com.maocanmao.mypass.di.module.AccountModule
import com.maocanmao.mypass.model.entity.Account
import com.maocanmao.mypass.mvp.contract.AccountContract
import com.maocanmao.mypass.mvp.presenter.AccountPresenter
import com.maocanmao.mypass.mvp.ui.activity.AddAccountActivity
import com.maocanmao.mypass.mvp.ui.adapter.HomeAccountListAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment(), AccountContract.View {


    @Inject
    lateinit var mPresenter: AccountPresenter

    private lateinit var mAccountListAdapter: HomeAccountListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAccountComponent.builder().appComponent(BaseApp.appComponent)
                .accountModule(AccountModule(this)).build().inject(this)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResume() {
        super.onResume()
        initUI()
        mPresenter.getAllAccount()
    }

    private fun initUI() {
        accountList.layoutManager = LinearLayoutManager(context)
        addPass.setOnClickListener {
            startActivity(Intent(activity, AddAccountActivity::class.java))
        }
    }

    override fun showMessage(message: String) {

    }

    override fun onAccountsLoaded(accounts: List<Account>) {
        mAccountListAdapter = HomeAccountListAdapter(accounts)
        accountList?.adapter = mAccountListAdapter
        mAccountListAdapter.notifyDataSetChanged()
    }

    override fun onAccountLoadFailed() {
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment HomeFragment.
         */
        @JvmStatic
        fun newInstance() =
                HomeFragment().apply {
                }
    }
}
