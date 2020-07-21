package com.example.lookfan.presenter.inter

import com.example.lookfan.base.BasePresenter
import com.example.lookfan.view.FanListView
import org.json.JSONObject

interface IFanListPresenter:BasePresenter<FanListView> {
    fun setResult(result: JSONObject,week:Int)
    fun loadData(week:String)
}