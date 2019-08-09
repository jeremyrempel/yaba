package com.github.jeremyrempel.yaba.list.service

import com.github.jeremyrempel.yaba.list.data.GetPhotosJsonResponse
import com.github.jeremyrempel.yaba.util.runBlocking
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.serialization.json.Json
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

        runBlocking {
            val client = HttpClient(MockEngine) {
                engine {
                    addHandler {
                        respond(
                            Json.nonstrict.stringify(
                                GetPhotosJsonResponse.serializer(),
                                expectedResponse
                            ),
                            HttpStatusCode.OK,
                            headersOf(HttpHeaders.ContentType, "application/json")
                        )
                    }
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer(Json.nonstrict)
                }
            }

            val result = client.get<GetPhotosJsonResponse>("/")

            assertEquals(result, expectedResponse)
        }
    }
}