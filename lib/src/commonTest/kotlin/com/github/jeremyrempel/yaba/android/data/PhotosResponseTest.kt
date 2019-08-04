import com.github.jeremyrempel.yaba.ui.GetPhotosJsonResponse
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class PhotosResponseTest {

    private val input = """{
  "total": 1000,
  "total_pages": 100,
  "results": [
    {
      "id": "kdGstD3te3M",
      "description": "Description of photo",
      "alt_description": "orange and black motorcycle",
      "urls": {
        "full": "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjM3MjkzfQ",
        "thumb": "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjM3MjkzfQ"
      }
    }
  ]
}""".trimIndent()

    @Test
    fun `test photo list parsing`() {

        val actualResult = Json.parse(GetPhotosJsonResponse.serializer(), input)

        val expectedResult = GetPhotosJsonResponse(
            1000, 100, listOf(
                GetPhotosJsonResponse.Result(
                    "kdGstD3te3M", "Description of photo", "orange and black motorcycle",
                    GetPhotosJsonResponse.Result.Urls(
                        "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjM3MjkzfQ",
                        "https://images.unsplash.com/photo-1558981408-db0ecd8a1ee4?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjM3MjkzfQ"
                    )
                )
            )
        )

        assertEquals(expectedResult, actualResult)
    }
}