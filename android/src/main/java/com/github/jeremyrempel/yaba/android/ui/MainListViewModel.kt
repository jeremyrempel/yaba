package com.github.jeremyrempel.yaba.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jeremyrempel.yaba.android.data.ImageResponseRow

class MainListViewModel : ViewModel() {

    private val data = MutableLiveData<ImageResponseRow>()
    private val showLoading = MutableLiveData<Boolean>()
    private val currentError = MutableLiveData<String>()
//    private val navEvent = SingleLiveEvent<NavScreen>()

    fun getData(): LiveData<ImageResponseRow> = data
    fun showLoading(): LiveData<Boolean> = showLoading
    fun showError(): LiveData<String> = currentError
}