package com.example.lookfan.net

abstract class MRequest<RESPONSE>(val type:Int,val url:String,val handler:ResponseHandler<RESPONSE>) {
    abstract fun paramResult(result: String) : RESPONSE?
}