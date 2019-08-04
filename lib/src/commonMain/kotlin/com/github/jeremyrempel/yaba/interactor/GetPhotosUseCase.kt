import com.github.jeremyrempel.yaba.android.data.ImageResponseRow

interface GetPhotosUseCase {
    fun getPhotoList(onComplete: (result: PhotosResponse) -> Unit, onError: (error: Throwable) -> Unit)
}