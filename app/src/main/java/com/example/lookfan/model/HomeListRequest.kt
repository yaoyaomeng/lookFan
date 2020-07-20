package com.example.lookfan.model

import android.os.Parcel
import android.os.Parcelable
import com.example.lookfan.R
import com.example.lookfan.bean.HomeBean
import com.example.lookfan.net.MRequest
import com.example.lookfan.net.ResponseHandler
import com.example.lookfan.presenter.inter.IHomePresenter
import com.example.lookfan.utils.Utils
import com.example.lookfan.view.HomeView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.*

class HomeListRequest(type:Int, url:String, handler: ResponseHandler<List<HomeBean>>, private val callback:IHomePresenter):MRequest<List<HomeBean>>(type,url,handler) {
    override fun paramResult(result: String): List<HomeBean>? {
            val body: Document = Jsoup.parse(result)
            val animeList: Elements? = body.getElementsByClass("anime_list").select("dl")
            if (animeList!!.size > 0) {
                val pages = body.select("div.page")
                if (pages.size > 0) {
                    val pageArr = pages[0].select("a").text().split(" ").toTypedArray()
                    callback.pageCount(pageArr[pageArr.size - 3].toInt())
                }
                val list = ArrayList<HomeBean>()
                for (i in animeList.indices) {
                    val bean = HomeBean()
                    bean.name = animeList[i].select("h3").text()
                    bean.img =
                        if (animeList[i].select("dt").select("img").attr("src").contains("http"))
                            animeList[i].select("dt").select("img")
                                .attr("src")
                        else
                            Utils.utils.getString(R.string.url)
                                .toString() + animeList[i].select("dt")
                                .select("img").attr("src")

                    bean.url = animeList[i].select("h3").select("a").attr("href")
                    val label = animeList[i].getElementsByClass("d_label")

                    for (k in label.indices) {
                        val str = label[k].text()
                        when {
                            str.contains("地区") -> bean.region = str
                            str.contains("年代") -> bean.year = str
                            str.contains("标签") -> bean.tag = str
                        }
                    }

                    val p = animeList[i].select("p")
                    for (j in p.indices) {
                        val str = p[j].text()
                        when {
                            str.contains("看点") -> bean.show = str
                            str.contains("简介") -> bean.desc = str
                            str.contains("状态") -> bean.state = str
                        }
                    }
                    list.add(bean)
                }
                return list
            } else {
                return null
            }
    }
}