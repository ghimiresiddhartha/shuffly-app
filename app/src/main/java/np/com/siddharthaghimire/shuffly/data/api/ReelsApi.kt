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

import np.com.siddharthaghimire.shuffly.BuildConfig.HEADER_I
import np.com.siddharthaghimire.shuffly.BuildConfig.I_ENDPOINT
import np.com.siddharthaghimire.shuffly.BuildConfig.I_HASHTAG_SEARCH
import np.com.siddharthaghimire.shuffly.data.models.instagram.InstagramReelsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ReelsApi {
    @GET(I_ENDPOINT)
    @Headers(HEADER_I)
    suspend fun fetchInstagramReelsVideos(
        @retrofit2.http.Header("X-RapidAPI-Key") apiKey: String,
        @Query("hashtag") hashtag: String = I_HASHTAG_SEARCH,
    ): Response<InstagramReelsResponse>

    @GET(I_ENDPOINT)
    @Headers(HEADER_I)
    suspend fun fetchInstagramReelsVideos(
        @retrofit2.http.Header("X-RapidAPI-Key") apiKey: String,
        @Query("hashtag") hashtag: String = I_HASHTAG_SEARCH,
        @Query("pagination_token") token: String
    ): Response<InstagramReelsResponse>
}
