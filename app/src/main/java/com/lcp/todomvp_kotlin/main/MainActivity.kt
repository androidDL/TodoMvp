package com.lcp.todomvp_kotlin.main

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lcp.todomvp_kotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,MainContract.IMainView{

    override lateinit var presenter: MainContract.IMainPresenter

    lateinit var dialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter=MainPresenter(this)
        presenter.start()
        bt_refresh.setOnClickListener {
            presenter.getData()
        }
    }

    override fun showLoading() {
        dialog= ProgressDialog.show(this,"获取新数据","获取中")
    }

    override fun hideLoading() {
        if(dialog?.isShowing)
            dialog.dismiss()
    }

    override fun showData(data: String) {
        tv_data.text=data
    }
}
