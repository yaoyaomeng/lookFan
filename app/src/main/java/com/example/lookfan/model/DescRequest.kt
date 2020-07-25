package com.example.lookfan.model

import com.example.lookfan.bean.AnimeDescBean
import com.example.lookfan.net.MRequest
import com.example.lookfan.net.ResponseHandler

class DescRequest(url:String,handler: ResponseHandler<AnimeDescBean>) : MRequest<AnimeDescBean>(0,url,handler) {

    override fun paramResult(result: String): AnimeDescBean? {
        TODO("Not yet implemented")
    }


}