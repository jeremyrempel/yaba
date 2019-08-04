package com.github.jeremyrempel.yaba.android.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.jeremyrempel.yaba.android.photolist.ui.PhotoListViewModel
import javax.inject.Inject
import javax.inject.Provider

class FragVmFactory @Inject constructor(
    private val mainListFragVm: Provider<PhotoListViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            PhotoListViewModel::class.java -> mainListFragVm.get()
            else -> TODO("Missing viewModel $modelClass")
        } as T
    }
}