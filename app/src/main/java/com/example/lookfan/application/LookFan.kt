package com.example.lookfan.application

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.lookfan.R
import com.example.lookfan.bean.HomeBean
import com.example.lookfan.model.FanTabRequest
import com.example.lookfan.model.HomeRequest
import com.example.lookfan.net.NetManager
import com.example.lookfan.net.ResponseHandler
import com.example.lookfan.utils.Utils
import org.json.JSONObject

class LookFan:Application() {

    companion object {
        var homeResult: JSONObject? = null
    }



    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
       // NetManager.netManager.sendRequest(HomeRequest(0, this.getString(R.string.url),this))
        NetManager.netManager.sendRequest(FanTabRequest(object:ResponseHandler<JSONObject>{
            override fun onError(e: String) {
                Log.d("", "onError: ")
            }

            override fun onSuccess(type: Int, result: JSONObject?) {
                 homeResult = result
            }

        }))

    }

}