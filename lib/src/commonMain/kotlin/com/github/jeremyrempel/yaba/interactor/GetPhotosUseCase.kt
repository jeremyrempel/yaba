package com.github.jeremyrempel.yaba.interactor

import com.github.jeremyrempel.yaba.android.data.ListPhotoResponseRow
import com.github.jeremyrempel.yaba.list.data.GetPhotosJsonResponse

interface GetPhotosUseCase {
    fun getPhotoList(
        onComplete: (result: List<ListPhotoResponseRow>) -> Unit,
        onError: (error: String) -> Unit
    )

    fun convertJsonToUi(input: GetPhotosJsonResponse): List<ListPhotoResponseRow>
}