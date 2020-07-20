package com.example.lookfan.ui.activity

import android.os.AsyncTask
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import com.example.lookfan.base.BaseActivity
import com.example.lookfan.R
import com.example.lookfan.net.NetManager
import com.example.lookfan.utils.FragmentCreateManagerUtils
import com.example.lookfan.utils.ToolbarManagerUtils
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener,ToolbarManagerUtils {
    override val toolbar: androidx.appcompat.widget.Toolbar by lazy { findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar) }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        initMainToolbar()
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom)
        bottomNavigation.setOnNavigationItemSelectedListener(this)
        bottomNavigation.selectedItemId = bottomNavigation.menu.getItem(0).itemId
    }

    override fun loadData() {
        Log.d("main", "loadData: ")
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val fragmentManager:FragmentManager = supportFragmentManager
        val transaction =  fragmentManager.beginTransaction()
        transaction.replace(R.id.replace,FragmentCreateManagerUtils.fragmentCreateManagerUtils.getFragment(p0.itemId)!!)
        transaction.commit()
        return true
    }



}