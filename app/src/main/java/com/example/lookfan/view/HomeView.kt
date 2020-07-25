package com.example.lookfan.view

import com.example.lookfan.bean.HomeBean

interface HomeView {
    fun onError(e:String)
    fun onSuccess(result: List<HomeBean>?)
    fun onLoadMore(result: List<HomeBean>?)
    fun pageCount(count:Int)


}