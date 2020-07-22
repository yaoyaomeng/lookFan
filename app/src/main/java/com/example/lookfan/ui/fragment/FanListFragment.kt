package com.example.lookfan.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lookfan.R
import com.example.lookfan.base.BaseFragment
import com.example.lookfan.bean.FanTabBean
import com.example.lookfan.presenter.impl.FanListPresenter
import com.example.lookfan.ui.activity.DescActivity
import com.example.lookfan.ui.adapter.FanWeekAdapter
import com.example.lookfan.utils.ThreadUtils
import com.example.lookfan.view.FanListView



class FanListFragment:BaseFragment(), FanListView, FanWeekAdapter.onMyClick {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_fan
    }

    private val adapter:FanWeekAdapter by lazy { FanWeekAdapter(context) }
    private val presenter = FanListPresenter.fanListPresenter
    private val week by lazy { arguments?.getString("args") }

    override fun initView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter = adapter
        adapter.setonMyClickListener(this)
        presenter.registerCallback(this)
    }



    override fun loadData() {
        if (week != null) {
            presenter.loadData(week!!)
        }
    }

    override fun onSuccess(result: List<FanTabBean>?) {
        ThreadUtils.onMainThread {
            adapter.updateData(result)
        }
    }

    override fun onError(e: String) {
        myToast(e)
    }

    override fun onDestroy() {
        presenter.unRegisterCallback(this)
        super.onDestroy()
    }

    override fun onTabClick(title: String?, url: String?) {
        if(title != null && url != null) {
            val bundle = Bundle()
            bundle.putString("title",title)
            bundle.putString("url",url)
            val intent = Intent(context,DescActivity::class.java)
            startActivity(intent.putExtras(bundle))
        }
    }


}