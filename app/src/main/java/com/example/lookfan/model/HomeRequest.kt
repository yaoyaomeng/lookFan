package com.example.lookfan.model

import com.example.lookfan.net.MRequest
import com.example.lookfan.net.ResponseHandler
import org.jsoup.Jsoup
import org.jsoup.nodes.*


class HomeRequest(type:Int,url:String,handler:ResponseHandler<String> ):MRequest<String>(type,url,handler) {
    override fun paramResult(result: String): String {
        val body:Document = Jsoup.parse(result)
        return body.select("ul.nav_lef > li")[1].select("a")[0].attr("href")
    }



}