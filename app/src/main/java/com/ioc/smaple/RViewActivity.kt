package com.ioc.smaple

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.ioc.library.InjectManager
import com.ioc.library.annotations.ContentView
import com.ioc.library.annotations.InjectView
import com.ioc.library.annotations.OnItemClick
import com.ioc.library.annotations.OnItemLongClick
import com.ioc.library.recyclerview.RView
import com.ioc.smaple.adapter.MyAdapter
import com.ioc.smaple.base.BaseActivity
import com.ioc.smaple.model.UserInfo

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/3/25
 * Description:
 */
@ContentView(R.layout.activity_recyclerview)
class RViewActivity: BaseActivity() {

    @InjectView(R.id.recyclerView)
    private var recyclerView: RView? = null

    private var datas = mutableListOf<UserInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initView()
    }

    private fun initData() {
        for (i in 1..50) {
            datas.add(UserInfo("测试测试测试 $i", i.toString()))
        }
    }

    private fun initView() {
        recyclerView!!.apply {
            layoutManager = LinearLayoutManager(this@RViewActivity)
            val myAdapter = MyAdapter(datas)
            setRViewAdapter(myAdapter)
            adapter = myAdapter
            InjectManager.injectEvents(this@RViewActivity)
        }
    }

    @OnItemClick(R.id.recyclerView)
    fun onItemClick(view: View, userInfo: UserInfo, position: Int) {
        Toast.makeText(this, "OnItemClick\t" + userInfo.password, Toast.LENGTH_SHORT).show()
    }

    @OnItemLongClick(R.id.recyclerView)
    fun onItemLongClick(view: View, userInfo: UserInfo, position: Int): Boolean {
        Toast.makeText(this, "onItemLongClick\t" + userInfo.password, Toast.LENGTH_SHORT).show()
        return true
    }
}