package com.ioc.smaple.base

import android.app.Activity
import android.os.Bundle
import com.ioc.library.InjectManager

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/3/25
 * Description:
 */
abstract class BaseActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //帮助子类进行布局、控件、事件的注入
        InjectManager.inject(this)
    }
}