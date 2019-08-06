package com.github.jeremyrempel.yaba.list.data

import kotlinx.serialization.Serializable

@Serializable
data class GetPhotosJsonResponse(
    val total: Int,
    val total_pages: Int,
    val results: List<Result>?
) {

    @Serializable
    data class Result(
        val id: String,
        val description: String?,
        val alt_description: String?,
        val urls: Urls
    ) {

        @Serializable
        data class Urls(
            val thumb: String,
            val full: String
        )
    }
}