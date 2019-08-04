package com.github.jeremyrempel.yaba.interactor

import GetPhotosUseCase
import PhotosResponse

internal class GetPhotosUseCaseKtor : GetPhotosUseCase {

    override fun getPhotoList(
        onComplete: (result: PhotosResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {

        val testResponse = PhotosResponse(
            1000, 100, listOf(
                PhotosResponse.Result(
                    "kdGstD3te3M", "Description of photo", "orange and black motorcycle",
                    PhotosResponse.Result.Urls(
                        "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjM3MjkzfQ",
                        "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjM3MjkzfQ"
                    )
                )
            )
        )

        onComplete(testResponse)
    }
}