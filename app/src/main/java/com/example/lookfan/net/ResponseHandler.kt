package com.example.lookfan.net

import com.example.lookfan.bean.HomeBean

interface ResponseHandler<RESPONSE> {
    fun onError(e:String)
    fun onSuccess(type:Int, result: RESPONSE?)
}