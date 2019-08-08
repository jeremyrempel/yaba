package com.github.jeremyrempel.yaba.list.service

import com.github.jeremyrempel.yaba.list.data.GetPhotosJsonResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get


class GetPhotosServiceKtor(
    client: HttpClient
) {

    suspend fun getPhotos(): GetPhotosJsonResponse {
        val client = HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer().apply {
                    register(GetPhotosJsonResponse.serializer())
                }
            }
        }

        val url =
            "https://api.unsplash.com/search/photos?page=1&client_id=159fd8a7b339701c499d851100f0cf81c1bcc66b9da9107c96b49887daa1e594&per_page=1&query=wallpaper"
        return client.get(url)
    }
}