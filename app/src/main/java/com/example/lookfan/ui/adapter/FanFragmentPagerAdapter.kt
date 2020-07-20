package com.example.lookfan.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.lookfan.R
import com.example.lookfan.bean.FanTabBean
import com.example.lookfan.ui.fragment.FanListFragment
import com.example.lookfan.utils.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class FanFragmentPagerAdapter(
    fm: FragmentManager,
    behavior: Int,
    val result: JSONObject?
) : FragmentPagerAdapter(fm, behavior) {
    private val title: Array<String> by lazy { Utils.utils.getStringArray(R.array.week_array)}


    override fun getItem(position: Int): Fragment {
        return FanListFragment(getList(title[position])!!)
    }

    override fun getCount(): Int {
        return title.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
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