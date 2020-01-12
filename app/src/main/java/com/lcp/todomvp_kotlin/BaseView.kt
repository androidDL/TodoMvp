package com.lcp.todomvp_kotlin

/**
 * View层，持有Presenter的引用
 */
interface BaseView<T>{
    var presenter:T
}