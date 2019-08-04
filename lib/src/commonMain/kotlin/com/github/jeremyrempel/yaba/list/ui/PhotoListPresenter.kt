package com.github.jeremyrempel.yaba.list.ui

import com.github.jeremyrempel.yaba.android.data.ListPhotoResponseRow

interface PhotoListPresenter {
    fun requestData()
    fun onData(response: List<ListPhotoResponseRow>)
    fun onError(error: String)
}