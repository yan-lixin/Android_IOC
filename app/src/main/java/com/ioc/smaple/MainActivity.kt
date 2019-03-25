package com.ioc.smaple

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.ioc.library.annotations.ContentView
import com.ioc.library.annotations.InjectView
import com.ioc.library.annotations.OnClick
import com.ioc.library.annotations.OnLongClick
import com.ioc.smaple.base.BaseActivity

@ContentView(R.layout.activity_main)
class MainActivity : BaseActivity() {

    @InjectView(R.id.tv)
    var textView: TextView? = null
    @InjectView(R.id.btn)
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        textView?.text = "123"
    }

    @OnClick(R.id.tv, R.id.btn)
    fun onClick(view: View) {
        when(view.id) {
            R.id.btn, R.id.tv-> {
                Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @OnLongClick(R.id.btn)
    fun onLongClick(view: View): Boolean {
        startActivity(Intent(this, RViewActivity::class.java))
        return true
    }

}
