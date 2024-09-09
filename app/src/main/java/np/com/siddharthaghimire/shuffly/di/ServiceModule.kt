/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package np.com.siddharthaghimire.shuffly.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import np.com.siddharthaghimire.shuffly.BuildConfig
import np.com.siddharthaghimire.shuffly.data.api.ReelsApi
import np.com.siddharthaghimire.shuffly.data.api.ShortsApi
import np.com.siddharthaghimire.shuffly.data.api.TiktokApi
import retrofit2.Retrofit

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
