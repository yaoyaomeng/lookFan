package com.example.lookfan.model

import com.example.lookfan.R
import com.example.lookfan.net.MRequest
import com.example.lookfan.net.ResponseHandler
import com.example.lookfan.utils.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class FanTabRequest(handler: ResponseHandler<JSONObject>)
    :MRequest<JSONObject>(0, Utils.utils.getString(R.string.url)!!,handler) {
    private val TABS: Array<String> = Utils.utils.getStringArray(R.array.week_array)
    override fun paramResult(result: String): JSONObject? {
        val weekObj:JSONObject = JSONObject()
        val body:Document = Jsoup.parse(result)
        setDataToJson(TABS[0],body.select("div.xfswiper0 >div.swiper-wrapper >div.swiper-slide >ul.clear > li"),weekObj)
        setDataToJson(TABS[1],body.select("div.xfswiper1 >div.swiper-wrapper >div.swiper-slide >ul.clear > li"),weekObj)
        setDataToJson(TABS[2],body.select("div.xfswiper2 >div.swiper-wrapper >div.swiper-slide >ul.clear > li"),weekObj)
        setDataToJson(TABS[3],body.select("div.xfswiper3 >div.swiper-wrapper >div.swiper-slide >ul.clear > li"),weekObj)
        setDataToJson(TABS[4],body.select("div.xfswiper4 >div.swiper-wrapper >div.swiper-slide >ul.clear > li"),weekObj)
        setDataToJson(TABS[5],body.select("div.xfswiper5 >div.swiper-wrapper >div.swiper-slide >ul.clear > li"),weekObj)
        setDataToJson(TABS[6],body.select("div.xfswiper6 >div.swiper-wrapper >div.swiper-slide >ul.clear > li"),weekObj)
        return weekObj
    }

    @Throws(JSONException::class)
    fun setDataToJson(
        title: String?,
        els: Elements,
        jsonObject: JSONObject
    ) {
        val arr = JSONArray()
        var i = 0
        val size = els.size
        while (i < size) {
            val fanObject = JSONObject()
            fanObject.put("title", els[i].select("img").attr("alt"))
            fanObject.put("img", els[i].select("img").attr("data-src"))
            fanObject.put("url", els[i].select("a").attr("href"))
            fanObject.put("drama", if (els[i].select("i") == null) "" else els[i].select("i").text())
            fanObject.put("new", els[i].select("b").text() == "new")
            arr.put(fanObject)
            i++
        }
        jsonObject.put(title, arr)
    }

}