package com.ioc.smaple.adapter

import android.widget.TextView
import com.ioc.library.recyclerview.RViewHolder
import com.ioc.library.recyclerview.RviewAdapter
import com.ioc.smaple.R
import com.ioc.smaple.model.UserInfo

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/3/25
 * Description:
 */
class MyAdapter(private var datas: List<UserInfo>): RviewAdapter<UserInfo>(datas) {
    override fun getLayoutId(): Int {
        return R.layout.item_recyclerview
    }

    override fun convert(holder: RViewHolder?, userInfo: UserInfo?) {
        var textView = holder?.getView<TextView>(R.id.tv)
        textView?.text = userInfo?.toString()
    }
}