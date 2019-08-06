package com.github.jeremyrempel.yaba.interactor

import com.github.jeremyrempel.yaba.android.data.ListPhotoResponseRow
import com.github.jeremyrempel.yaba.list.data.GetPhotosJsonResponse

class GetPhotosUseCaseKtor : GetPhotosUseCase {

    override fun getPhotoList(
        onComplete: (result: List<ListPhotoResponseRow>) -> Unit,
        onError: (error: String) -> Unit
    ) {

        val testResponse = GetPhotosJsonResponse(
            1000, 100, listOf(
                GetPhotosJsonResponse.Result(
                    "kdGstD3te3M", "Description of photo", "orange and black motorcycle",
                    GetPhotosJsonResponse.Result.Urls(
                        "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjM3MjkzfQ",
                        "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjM3MjkzfQ"
                    )
                ),
                GetPhotosJsonResponse.Result(
                    "kdGstD3te3M", "Description of photo 2", "orange and black motorcycle",
                    GetPhotosJsonResponse.Result.Urls(
                        "https://images.unsplash.com/photo-1565022888585-5786a818c039?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjM3MjkzfQ",
                        "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjM3MjkzfQ"
                    )
                )
            )
        )

        val formattedResponse = convertJsonToUi(testResponse)
        onComplete(formattedResponse)
    }

    override fun convertJsonToUi(input: GetPhotosJsonResponse): List<ListPhotoResponseRow> {
        return input.results?.let { photoResults ->
            photoResults.map {
                ListPhotoResponseRow(it.description ?: "", it.urls.thumb)
            }
        } ?: listOf()
    }
}