package com.example.lookfan.base

import javax.security.auth.callback.Callback

interface BasePresenter<T> {
    fun registerCallback(callback:T)
    fun unRegisterCallback(callback: T)
    fun loadData()
}