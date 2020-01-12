package com.lcp.todomvp_kotlin.main

import android.os.Handler
import android.os.Looper
import kotlin.random.Random

/**
 * 具体的Presenter持有具体的View的引用，方便数据更新之后更新View。
 * 从这里能看出来与MVVM的区别，MVVM中，VM不持有View的引用，View的界面更新是直接通过注册ViewModel的观察者
 * 的监听器来实现的。
 */
class MainPresenter(private val mainView: MainContract.IMainView) : MainContract.IMainPresenter {
    val handler = Handler(Looper.getMainLooper())
    override fun start() {
    }

    override fun getData() {

        Thread {

            showLoading()
            Thread.sleep(5000)
            hideLoading()
            showData("${Random.nextInt()}")

        }.start()
    }

    fun showData(data:String){
        handler.post{
            mainView.showData(data)
        }
    }

    fun showLoading() {
        handler.post {
            mainView.showLoading()
        }
    }

    fun hideLoading() {
        handler.post {
            mainView.hideLoading()
        }
    }
}