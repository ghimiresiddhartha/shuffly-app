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
package np.com.siddharthaghimire.shuffly.data.api

import np.com.siddharthaghimire.shuffly.BuildConfig.HEADER_T
import np.com.siddharthaghimire.shuffly.BuildConfig.MAX_RESULT
import np.com.siddharthaghimire.shuffly.BuildConfig.SEARCH_ENDPOINT
import np.com.siddharthaghimire.shuffly.BuildConfig.T_SEARCH_KEYWORD
import np.com.siddharthaghimire.shuffly.BuildConfig.T_TRENDING_ENDPOINT
import np.com.siddharthaghimire.shuffly.data.models.tiktok.search.TiktokSearchResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.trending.TiktokTrendingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TiktokApi {

    @GET(T_TRENDING_ENDPOINT)
    @Headers(HEADER_T)
    suspend fun fetchTiktokTrendingVideos(
        @retrofit2.http.Header("X-RapidAPI-Key") apiKey: String,
        @Query("region") region: String,
        @Query("count") count: Int = MAX_RESULT
    ): Response<TiktokTrendingResponse>

    @GET(SEARCH_ENDPOINT)
    @Headers(HEADER_T)
    suspend fun fetchTiktokSearchVideos(
        @retrofit2.http.Header("X-RapidAPI-Key") apiKey: String,
        @Query("region") region: String,
        @Query("cursor") cursor: Int,
        @Query("keywords") keyword: String = T_SEARCH_KEYWORD,
        @Query("count") count: Int = MAX_RESULT,
        @Query("publish_time") publishTime: Int = 0,
        @Query("sort_type") sortType: Int = 0
    ): Response<TiktokSearchResponse>
}
