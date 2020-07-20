package com.example.lookfan.ui.fragment

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.lookfan.base.BaseFragment
import com.example.lookfan.R
import com.example.lookfan.bean.HomeBean
import com.example.lookfan.presenter.impl.HomePresenter
import com.example.lookfan.ui.adapter.HomeListAdapter
import com.example.lookfan.utils.ThreadUtils
import com.example.lookfan.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment:BaseFragment(), HomeView {
    var nowPage:Int = 0
    var page:Int = 0

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    private val presenter:HomePresenter by lazy { HomePresenter() }
    private val homeListAdapter by lazy { HomeListAdapter(context)  }

    override fun initView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_home)
        val swipeRefresh =view.findViewById<SwipeRefreshLayout>(R.id.swipe)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = homeListAdapter
        swipeRefresh.setColorSchemeColors(Color.RED,Color.DKGRAY,Color.YELLOW)
        swipeRefresh.isRefreshing = true
        presenter.registerCallback(this)
        swipeRefresh.setOnRefreshListener {
            presenter.loadData()
        }
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val manager = recyclerView.layoutManager
                    if (manager is LinearLayoutManager) {
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == homeListAdapter.itemCount - 1) {
                            if (page >= nowPage) {
                                Toast.makeText(context,"数据已全部加载",Toast.LENGTH_LONG).show()
                            }else {
                                page++
                                //Log.d("调试加载", "onScrollStateChanged: $page")
                                presenter.loadMore(page)
                            }
                        }
                    }
                }
            }
        })
    }

    override fun loadData() {
        presenter.loadData()
    }

    override fun onError(e: String) {
        Toast.makeText(context,e,Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(result: List<HomeBean>?) {
        ThreadUtils.onMainThread {
            homeListAdapter.updateData(result)
            swipe.isRefreshing = false
        }
        page = 0
    }

    override fun onLoadMore(result: List<HomeBean>?) {
        ThreadUtils.onMainThread {
            homeListAdapter.updateMore(result)
            swipe.isRefreshing = false
        }
    }

    override fun pageCount(count: Int) {
        nowPage = count
    }

    override fun onDestroy() {
        presenter.unRegisterCallback(this)
        Log.d("调试生命周期", "onDestroy: ")
        super.onDestroy()
    }


}