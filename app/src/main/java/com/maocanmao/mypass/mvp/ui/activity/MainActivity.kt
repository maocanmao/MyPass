package com.maocanmao.mypass.mvp.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.maocanmao.mypass.R
import com.maocanmao.mypass.appinfra.AppManager
import com.maocanmao.mypass.appinfra.BaseApp
import com.maocanmao.mypass.mvp.ui.fragment.HomeFragment
import com.maocanmao.mypass.mvp.ui.fragment.Settingragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var appManager:AppManager

    private var exitTime :Long = 0


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                loadFragment(HomeFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_setting -> {
                loadFragment(Settingragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseApp.appComponent.inject(this)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadFragment(HomeFragment.newInstance())
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (KeyEvent.KEYCODE_BACK ==keyCode){
            if(System.currentTimeMillis() -exitTime >2000){
                appManager.makeToast(this,getString(R.string.press_to_exit))
                exitTime = System.currentTimeMillis()
            }else{
                appManager.killAllActivities()
            }
        }
        return true

    }
}
