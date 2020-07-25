package com.example.lookfan.view

import org.json.JSONObject

interface DescView {
    fun onError(e:String)
    fun onSuccess(result: JSONObject?)
}