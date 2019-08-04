package com.github.jeremyrempel.yaba.di

import com.github.jeremyrempel.yaba.android.GetPhotoUseCaseModule
import com.github.jeremyrempel.yaba.android.factory.FactoryModule
import com.github.jeremyrempel.yaba.android.factory.FragFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        FactoryModule::class,
        GetPhotoUseCaseModule::class
    ]
)
interface AppComponent {
    fun fragFactory(): FragFactory
}