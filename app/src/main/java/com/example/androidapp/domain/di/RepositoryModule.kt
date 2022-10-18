package com.example.androidapp.domain.di

import com.example.androidapp.data.network.service.HomeService
import com.example.androidapp.presentation.screen.home.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideHomeRepository(homeService: HomeService): HomeRepository {
        return HomeRepository(homeService = homeService)
    }
}