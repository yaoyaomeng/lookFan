package com.example.lookfan.ui.fragment

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.example.lookfan.R
import com.example.lookfan.base.BaseFragment
import com.example.lookfan.presenter.impl.FabTabPresenter
import com.example.lookfan.presenter.impl.FanListPresenter
import com.example.lookfan.ui.adapter.FanFragmentPagerAdapter
import com.example.lookfan.utils.ThreadUtils
import com.example.lookfan.utils.Utils
import com.example.lookfan.view.FanTabView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_fantable.*
import org.json.JSONObject
import java.util.*


class FanTableFragment:BaseFragment(), FanTabView {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_fantable
    }

    private val presenter by lazy { FabTabPresenter() }
    private val week by lazy {  Utils.utils.getWeekOfDate(Date())  }
    override fun initView(view: View) {
        presenter.registerCallback(this)
        val tab = view.findViewById<TabLayout>(R.id.fanTab_tab)
        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.fan_swipe)
        val pager = view.findViewById<ViewPager>(R.id.fanTab_pager)
        val adapter = FanFragmentPagerAdapter(childFragmentManager,0)
        pager.adapter = adapter
        tab.setupWithViewPager(pager)
        swipe.setColorSchemeColors(Color.RED,Color.YELLOW)
        swipe.isRefreshing = true
        swipe.setOnRefreshListener {
            presenter.loadData()
        }
        tab.getTabAt(week)?.select()
    }

    override fun loadData() {
        presenter.loadData()
    }

    override fun onError(e: String) {
        Toast.makeText(context,e,Toast.LENGTH_LONG).show()
    }

    private val fanListPresenter = FanListPresenter.fanListPresenter
    override fun onSuccess(result: JSONObject?) {
        if (result != null) {
            fanListPresenter.setResult(result,week)
            ThreadUtils.onMainThread {
                if (fan_swipe != null) {
                    fan_swipe.isRefreshing = false
                }
            }
        }else {
            Toast.makeText(context,"代码解析失败",Toast.LENGTH_LONG).show()
        }
    }
}