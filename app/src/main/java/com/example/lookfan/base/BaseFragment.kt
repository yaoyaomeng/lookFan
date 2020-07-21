package com.example.lookfan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lookfan.utils.ThreadUtils

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

    fun myToast(string:String) {
        ThreadUtils.onMainThread {
            Toast.makeText(context,string,Toast.LENGTH_LONG).show()
        }
    }

    abstract fun getLayoutRes(): Int

    abstract fun initView(view:View)

    abstract fun loadData()
}