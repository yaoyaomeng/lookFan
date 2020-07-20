package com.example.lookfan.net

import android.util.Log
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class NetManager private constructor() {

    companion object {
        val netManager by lazy { NetManager() }
    }

    private val connectTimeout = 10
    private val readTimeout = 20

    private val client:OkHttpClient by lazy { OkHttpClient.Builder()
        .connectTimeout(connectTimeout.toLong(), TimeUnit.SECONDS)
        .readTimeout(readTimeout.toLong(), TimeUnit.SECONDS)
        .build()
    }

    fun <RESPONSE>sendRequest(req:MRequest<RESPONSE>) {
        val request = Request.Builder()
            .url(req.url)
            .get()
            .build()
        val call = client.newCall(request)
        call.enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                req.handler.onError(e.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                val result = response.body!!.string()
                val paramResult = req.paramResult(result)
                if (paramResult == null) {
                    req.handler.onError(" 内容为空")
                }else {
                    req.handler.onSuccess(req.type,paramResult)
                }
            }
        })
    }

}