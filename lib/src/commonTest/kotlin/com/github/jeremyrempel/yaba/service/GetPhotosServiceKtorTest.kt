package com.github.jeremyrempel.yaba.list.service

import com.github.jeremyrempel.yaba.list.data.GetPhotosJsonResponse
import com.github.jeremyrempel.yaba.util.runBlockingTest
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlin.test.Test
import kotlin.test.assertEquals


class GetPhotosServiceKtorTest {

    @Test
    fun testApiResponse() {

        val expectedResponse = GetPhotosJsonResponse(
            1000,
            100,
            listOf(
                GetPhotosJsonResponse.Result(
                    "kdGstD3te3M",
                    "Description of photo",
                    "orange and black motorcycle",
                    GetPhotosJsonResponse.Result.Urls(
                        "thumb.jpg",
                        "full.jpg"
                    )
                )
            )
        )


        runBlockingTest {
            val client = HttpClient(MockEngine) {
                engine {
                    addHandler {
                        respondOk(
                            Json.nonstrict.stringify(
                                GetPhotosJsonResponse.serializer(),
                                expectedResponse
                            )
                        )
                    }
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer(Json.nonstrict).apply {
                        register(GetPhotosJsonResponse.serializer())
                    }
                }
            }

            val response = client.get<String>("/")
            val json = Json(JsonConfiguration.Stable)
            val result = json.parse(GetPhotosJsonResponse.serializer(), response)

            assertEquals(result, expectedResponse)
        }
    }
}