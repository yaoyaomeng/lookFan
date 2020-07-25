package com.example.lookfan.presenter.inter

import com.example.lookfan.base.BasePresenter
import com.example.lookfan.view.DescView

interface IDescPresenter : BasePresenter<DescView> {
      fun loadData(url:String)
}