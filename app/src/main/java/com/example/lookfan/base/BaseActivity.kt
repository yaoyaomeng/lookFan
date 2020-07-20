package com.example.lookfan.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initView()
    }

    abstract fun getLayoutRes(): Int

    abstract fun initView()

    abstract fun loadData()
}