package com.maocanmao.mypass.appinfra

import android.app.Activity
import android.content.Context
import android.widget.Toast
import java.util.*
import javax.inject.Inject

/**
 * Activity 管理类
 * Created by zhouyang on 2018/6/14.
 */
class AppManager @Inject constructor() {

    private var mActivityList: MutableList<Activity> = LinkedList()

    fun makeToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }


    fun addActivity(activity: Activity) {
        synchronized(AppManager().javaClass, {
            val activities: MutableList<Activity> = getActivityList()
            if (!activities.contains(activity)) {
                activities.add(activity)
            }
        })
    }


    fun removeActivity(activity: Activity) {
        synchronized(AppManager::class) {
            mActivityList.remove(activity)
        }
    }

    private fun getActivityList(): MutableList<Activity> {
        return mActivityList
    }

    fun killAllActivities() {
        synchronized(AppManager::class) {
            for (activity in mActivityList) {
                activity.finish()
                mActivityList.remove(activity)
            }
        }
    }
}