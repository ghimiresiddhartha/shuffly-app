package np.com.siddharthaghimire.shuffly.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import np.com.siddharthaghimire.shuffly.BuildConfig
import np.com.siddharthaghimire.shuffly.data.api.ReelsApi
import np.com.siddharthaghimire.shuffly.data.api.ShortsApi
import np.com.siddharthaghimire.shuffly.data.api.TiktokApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideYoutubeService(retrofitBuilder: Retrofit.Builder): ShortsApi =
        retrofitBuilder.baseUrl(BuildConfig.BASE_URL_Y).build().create(ShortsApi::class.java)

    @Singleton
    @Provides
    fun provideTiktokService(retrofitBuilder: Retrofit.Builder): TiktokApi =
        retrofitBuilder.baseUrl(BuildConfig.BASE_URL_T).build().create(TiktokApi::class.java)

    @Singleton
    @Provides
    fun provideInstagramService(retrofitBuilder: Retrofit.Builder): ReelsApi =
        retrofitBuilder.baseUrl(BuildConfig.BASE_URL_I).build().create(ReelsApi::class.java)

}