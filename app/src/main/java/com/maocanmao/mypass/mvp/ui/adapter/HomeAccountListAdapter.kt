package com.maocanmao.mypass.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maocanmao.mypass.R
import com.maocanmao.mypass.model.entity.Account
import kotlinx.android.synthetic.main.item_account.view.*

/**
 * Created by zhouyang on 2018/6/21.
 */
class HomeAccountListAdapter(private var mList: List<Account>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(account: Account) {
            itemView.account_description.text = when (account.title?.length) {
                in 0..4 -> account.title
                else ->
                    account.title.toString().subSequence(0, 3).toString() + "..."
            }
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AccountViewHolder).bind(mList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_account, parent, false)
        return AccountViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}