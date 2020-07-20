package com.example.lookfan.presenter.impl

import android.widget.Toast
import com.example.lookfan.base.BasePresenter
import com.example.lookfan.model.FanTabRequest
import com.example.lookfan.net.NetManager
import com.example.lookfan.net.ResponseHandler
import com.example.lookfan.view.FanTabView
import org.json.JSONObject

class FabTabPresenter:BasePresenter<FanTabView>, ResponseHandler<JSONObject> {
    private var mCallback:FanTabView? =null

    override fun registerCallback(callback: FanTabView) {
        mCallback = callback
    }

    override fun unRegisterCallback(callback: FanTabView) {
        mCallback = null
    }

    override fun loadData() {
        NetManager.netManager.sendRequest(FanTabRequest(this))
    }

    override fun onError(e: String) {
        if (mCallback != null) {
            mCallback!!.onError(e)
        }
    }

    override fun onSuccess(type: Int, result: JSONObject?) {
        if (mCallback != null) {
            mCallback!!.onSuccess(result)
        }
    }
}