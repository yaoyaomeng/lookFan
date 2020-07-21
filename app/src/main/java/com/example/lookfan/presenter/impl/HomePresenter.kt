package com.example.lookfan.presenter.impl

import android.util.Log
import com.example.lookfan.R
import com.example.lookfan.bean.HomeBean
import com.example.lookfan.model.HomeListRequest
import com.example.lookfan.model.HomeRequest
import com.example.lookfan.net.NetManager
import com.example.lookfan.net.ResponseHandler
import com.example.lookfan.presenter.inter.IHomePresenter
import com.example.lookfan.utils.Utils
import com.example.lookfan.view.HomeView


class HomePresenter:IHomePresenter, ResponseHandler<List<HomeBean>> {
    private var mCallback: HomeView? = null
    private var url:String? = null

    override fun loadMore(page:Int) {
        if(url != null) {
            NetManager.netManager.sendRequest(HomeListRequest(1,url + page,this,this))
        }
    }

    override fun pageCount(count: Int) {
        if (mCallback != null) {
            mCallback!!.pageCount(count)
        }
    }

    override fun registerCallback(callback: HomeView) {
        this.mCallback = callback
    }

    override fun unRegisterCallback(callback: HomeView) {
        this.mCallback = null
    }

    override fun loadData() {
        NetManager.netManager.sendRequest(HomeRequest(0, Utils.utils.getString(R.string.url)!!,object :
            ResponseHandler<String> {
            override fun onError(e: String) {
                if (mCallback != null) {
                    mCallback!!.onError(e)
                }
            }

            override fun onSuccess(type: Int, result: String?) {
                if (result != null) {
                    val url =Utils.utils.getString(R.string.url) + result
                    loadData(url)
                }
            }
        }))
    }

    fun loadData(url:String) {
        NetManager.netManager.sendRequest(HomeListRequest(0,url + "0",this,this))
        this.url = url
    }

    override fun onError(e: String) {
        mCallback!!.onError(e)
    }

    override fun onSuccess(type: Int, result: List<HomeBean>?) {
        if (type == 0) {
            if (mCallback != null) {
                mCallback!!.onSuccess(result)
            }
        }else if (type == 1) {
            mCallback!!.onLoadMore(result)
        }
    }


}