package com.example.lookfan.utils


import android.widget.Toast
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.lookfan.R

interface ToolbarManagerUtils {
    val toolbar:androidx.appcompat.widget.Toolbar

    fun initMainToolbar() {
        toolbar.title = "看番"
        toolbar.setTitleTextColor(ContextCompat.getColor(toolbar.context,R.color.colorTitle))
        toolbar.inflateMenu(R.menu.menu)
        toolbar.setOnMenuItemClickListener{
            when(it.itemId) {
                R.id.search -> Toast.makeText(toolbar.context,"你点击搜索",Toast.LENGTH_LONG).show()
            }
            true
        }
    }
}
