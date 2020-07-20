package com.example.lookfan.presenter.inter

import com.example.lookfan.base.BasePresenter
import com.example.lookfan.view.HomeView

interface IHomePresenter:BasePresenter<HomeView> {
    fun loadMore(page:Int)
    fun pageCount(count:Int)
}