package com.github.jeremyrempel.yaba.android

import com.github.jeremyrempel.yaba.interactor.GetPhotosUseCase
import com.github.jeremyrempel.yaba.interactor.GetPhotosUseCaseKtor
import dagger.Module
import dagger.Provides

@Module
class GetPhotoUseCaseModule {

    @Provides
    fun providesGetPhotoUseCase(): GetPhotosUseCase = GetPhotosUseCaseKtor()
}