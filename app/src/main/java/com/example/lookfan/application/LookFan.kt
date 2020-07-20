package com.example.lookfan.application

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.lookfan.R
import com.example.lookfan.bean.HomeBean
import com.example.lookfan.model.HomeRequest
import com.example.lookfan.net.NetManager
import com.example.lookfan.net.ResponseHandler
import com.example.lookfan.utils.Utils

class LookFan:Application(){
    private val appContext: LookFan? = null

    companion object {
        var homeUrl:String? = null
    }

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
       // NetManager.netManager.sendRequest(HomeRequest(0, this.getString(R.string.url),this))
    }

}