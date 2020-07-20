package com.example.lookfan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:View = View.inflate(context,getLayoutRes(),null)
        initView(rootView)
        loadData()
        return rootView
    }

    abstract fun getLayoutRes(): Int

    abstract fun initView(view:View)

    abstract fun loadData()
}