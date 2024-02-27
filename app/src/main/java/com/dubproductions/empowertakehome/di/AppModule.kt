package com.dubproductions.empowertakehome.di

import android.app.Application
import android.content.Context
import com.dubproductions.empowertakehome.data.dataUtils.JSONParser
import com.dubproductions.empowertakehome.data.repository.BeneficiariesRepositoryImpl
import com.dubproductions.empowertakehome.domain.repository.BeneficiariesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesJsonParser(
        context: Context
    ): JSONParser {
        return JSONParser(context)
    }

    @Provides
    @Singleton
    fun provideBeneficiariesRepository(
        jsonParser: JSONParser
    ): BeneficiariesRepository {
        return BeneficiariesRepositoryImpl(jsonParser)
    }

}
