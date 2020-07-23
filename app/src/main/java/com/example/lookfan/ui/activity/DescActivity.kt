package com.example.lookfan.ui.activity


import android.util.Log
import com.example.lookfan.R
import com.example.lookfan.base.BaseActivity
import com.google.android.material.appbar.CollapsingToolbarLayout


class DescActivity : BaseActivity() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_desc
    }


    override fun initView() {
        val bundle = intent.extras!!
        if (!bundle.isEmpty) {
            Log.d("临时参数调试", "initView:" + bundle.getString("url"))
        }

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_desc)
        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        setSupportActionBar(toolbar)
        this.actionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun loadData() {
        Log.d("desc", "loadData: ")
    }

}