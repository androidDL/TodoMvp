package com.lcp.todomvp_kotlin.main

import com.lcp.todomvp_kotlin.BasePresenter
import com.lcp.todomvp_kotlin.BaseView

interface MainContract {

    interface IMainView :
        BaseView<IMainPresenter> {
        fun showData(data: String)
        fun showLoading()
        fun hideLoading()
    }

    interface IMainPresenter : BasePresenter {
        fun getData()
    }
}