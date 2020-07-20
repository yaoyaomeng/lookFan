package com.example.lookfan.ui.fragment

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lookfan.R
import com.example.lookfan.base.BaseFragment
import com.example.lookfan.bean.FanTabBean
import com.example.lookfan.ui.adapter.FanWeekAdapter
import org.w3c.dom.Text

class FanListFragment(val bean:List<FanTabBean>):BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_fan
    }
    private val adapter:FanWeekAdapter by lazy { FanWeekAdapter(context) }
    override fun initView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter = adapter
    }

    override fun loadData() {
        adapter.updateData(bean)
    }

}