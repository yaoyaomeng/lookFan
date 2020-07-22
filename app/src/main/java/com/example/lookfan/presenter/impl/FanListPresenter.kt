package com.example.lookfan.presenter.impl

import android.util.Log
import com.example.lookfan.R
import com.example.lookfan.application.LookFan
import com.example.lookfan.bean.FanTabBean
import com.example.lookfan.presenter.inter.IFanListPresenter
import com.example.lookfan.utils.Utils
import com.example.lookfan.view.FanListView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class FanListPresenter private constructor():IFanListPresenter {
    companion object {
        val fanListPresenter by lazy { FanListPresenter() }
    }

    private var result:JSONObject? = null
    private var mCallback:FanListView? = null

    override fun setResult(result: JSONObject, week: Int) {
        this.result = result
    }

    override fun loadData(week: String) {
        if (result != null) {
            mCallback!!.onSuccess(getList(week))
        }else {
            if (LookFan.homeResult != null) {
                this.result = LookFan.homeResult
                mCallback!!.onSuccess(getList(week))
            }
        }
    }

    override fun loadData() {

    }

    override fun registerCallback(callback: FanListView) {
        mCallback = callback
    }

    override fun unRegisterCallback(callback: FanListView) {
        mCallback = null
    }

    private fun getList(week: String): List<FanTabBean>? {
        val list = ArrayList<FanTabBean>()
        try {
            val arr = JSONArray(result?.getString(week))
            for (i in 0 until arr.length()) {
                val json = JSONObject(arr.getString(i))
                list.add(
                    FanTabBean(
                        json.getString("title"),
                        json.getString("img"),
                        json.getString("url"),
                        json.getString("drama"),
                        json.getBoolean("new")
                    )
                )
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }


}