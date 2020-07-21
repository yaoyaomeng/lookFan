package com.example.lookfan.view

import com.example.lookfan.bean.FanTabBean

interface FanListView {
    fun onSuccess(result :List<FanTabBean>?)
    fun onError(e:String)
}