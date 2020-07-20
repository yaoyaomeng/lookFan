package com.example.lookfan.ui.fragment

import android.util.Log
import android.view.View
import com.example.lookfan.base.BaseFragment
import com.example.lookfan.R

class AboutFragment:BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_about
    }

    override fun initView(view: View) {
        Log.d("home", "initView: ")
    }

    override fun loadData() {
        Log.d("home", "initView: ")
    }
}