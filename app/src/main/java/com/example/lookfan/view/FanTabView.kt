package com.example.lookfan.view

import org.json.JSONObject

interface FanTabView {
    fun onError(e:String)
    fun onSuccess(result: JSONObject?)
}