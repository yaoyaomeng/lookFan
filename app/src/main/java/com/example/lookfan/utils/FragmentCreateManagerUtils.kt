package com.example.lookfan.utils

import com.example.lookfan.base.BaseFragment
import com.example.lookfan.R
import com.example.lookfan.ui.fragment.AboutFragment
import com.example.lookfan.ui.fragment.ClassificationFragment
import com.example.lookfan.ui.fragment.FanTableFragment
import com.example.lookfan.ui.fragment.HomeFragment

class FragmentCreateManagerUtils private constructor() {
    companion object {
        val fragmentCreateManagerUtils:FragmentCreateManagerUtils by lazy { FragmentCreateManagerUtils() }
    }

    private val homeFragment:HomeFragment by lazy { HomeFragment() }
    private val classificationFragment by lazy { ClassificationFragment() }
    private val fanTableFragment by lazy { FanTableFragment() }
    private val aboutFragment by lazy { AboutFragment() }

    fun getFragment(id:Int) :BaseFragment? {
        when(id) {
            R.id.tab_one -> return homeFragment
            R.id.tab_two -> return fanTableFragment
            R.id.tab_three -> return classificationFragment
            R.id.tab_four -> return aboutFragment
        }
        return null
    }
}