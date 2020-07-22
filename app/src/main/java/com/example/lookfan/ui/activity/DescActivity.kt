package com.example.lookfan.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.TextureView
import android.view.View
import android.widget.TextView
import com.example.lookfan.R
import com.example.lookfan.base.BaseActivity
import com.example.lookfan.base.BaseFragment
import kotlinx.android.synthetic.main.activity_desc.*

class DescActivity : BaseActivity() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_desc
    }

    override fun initView() {
        Log.d("desc", "loadData:")
    }

    override fun loadData() {
        Log.d("desc", "loadData: ")
    }

}