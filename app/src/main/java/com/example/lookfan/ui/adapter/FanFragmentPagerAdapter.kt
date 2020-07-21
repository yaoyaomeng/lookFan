package com.example.lookfan.ui.adapter

import android.os.Bundle
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
    behavior: Int
) : FragmentPagerAdapter(fm, behavior) {
    private val title: Array<String> by lazy { Utils.utils.getStringArray(R.array.week_array)}

    override fun getItem(position: Int): Fragment {
        val fragment = FanListFragment()
        val bundle = Bundle()
        bundle.putString("args",title[position])
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return title.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }


}