package com.example.lookfan.ui.activity



import android.util.Log
import com.example.lookfan.R
import com.example.lookfan.base.BaseActivity
import kotlinx.android.synthetic.main.activity_desc.*
import com.example.lookfan.presenter.impl.DescPresenter
import com.example.lookfan.view.DescView
import org.json.JSONObject


class DescActivity : BaseActivity(), DescView {
    override fun getLayoutRes(): Int {
        return R.layout.activity_desc
    }


    val presenter by lazy { DescPresenter() }
    override fun initView() {
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_desc)
        setSupportActionBar(toolbar)
        val action = supportActionBar!!
        action.setDisplayHomeAsUpEnabled(true)
        action.setDisplayShowTitleEnabled(false)
        presenter.registerCallback(this)
        val bundle = intent.extras!!
        if (!bundle.isEmpty) {
            desc_title.text = bundle.getString("title")

        }

    }

    override fun loadData() {

    }


    override fun onError(e: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(result: JSONObject?) {
        TODO("Not yet implemented")
    }

}