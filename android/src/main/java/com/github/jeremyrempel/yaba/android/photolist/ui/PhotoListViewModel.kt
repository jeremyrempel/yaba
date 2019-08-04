package com.github.jeremyrempel.yaba.android.photolist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jeremyrempel.yaba.android.data.ListPhotoResponseRow
import com.github.jeremyrempel.yaba.interactor.GetPhotosUseCase
import com.github.jeremyrempel.yaba.list.ui.PhotoListPresenter
import javax.inject.Inject

class PhotoListViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel(), PhotoListPresenter {

    private var hasRequestedData = false

    private val data = MutableLiveData<List<ListPhotoResponseRow>>()
    private val showLoading = MutableLiveData<Boolean>()
    private val currentError = MutableLiveData<String>()
//    private val navEvent = SingleLiveEvent<NavScreen>()

    override fun requestData() {
        hasRequestedData = true
        showLoading.value = true

        // todo extract to presenter?
        getPhotosUseCase.getPhotoList(::onData, ::onError)

        showLoading.value = false
    }

    override fun onData(response: List<ListPhotoResponseRow>) {
        data.value = response
    }

    override fun onError(error: String) {
        currentError.value = error
    }

    fun getData(): LiveData<List<ListPhotoResponseRow>> {
        if (!hasRequestedData) {
            requestData()
        }

        return data
    }

    fun showLoading(): LiveData<Boolean> = showLoading

    fun showError(): LiveData<String> = currentError
}