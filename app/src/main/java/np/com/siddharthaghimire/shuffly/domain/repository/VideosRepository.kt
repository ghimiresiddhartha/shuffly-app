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
package np.com.siddharthaghimire.shuffly.domain.repository

import javax.inject.Inject
import np.com.siddharthaghimire.shuffly.data.api.ReelsApi
import np.com.siddharthaghimire.shuffly.data.api.ShortsApi
import np.com.siddharthaghimire.shuffly.data.api.TiktokApi
import np.com.siddharthaghimire.shuffly.data.models.instagram.InstagramReelsResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.search.TiktokSearchResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.trending.TiktokTrendingResponse
import np.com.siddharthaghimire.shuffly.data.models.youtube.YoutubeShortsResponse
import retrofit2.Response

class VideosRepository @Inject constructor(
    private val shortsApi: ShortsApi,
    private val tiktokApi: TiktokApi,
    private val reelsApi: ReelsApi
) {
    suspend fun getYoutubeShorts(apiKey: String, token: String): Response<YoutubeShortsResponse> {
        return shortsApi.fetchYoutubeShorts(apiKey, token = token)
    }

    suspend fun getTiktokSearchData(
        apiKey: String,
        region: String,
        cursor: Int
    ): Response<TiktokSearchResponse> {
        return tiktokApi.fetchTiktokSearchVideos(apiKey, region, cursor)
    }

    suspend fun getTiktokTrendingData(
        apiKey: String,
        region: String
    ): Response<TiktokTrendingResponse> {
        return tiktokApi.fetchTiktokTrendingVideos(apiKey, region)
    }

    suspend fun getInstagramReelsData(
        apiKey: String,
        token: String
    ): Response<InstagramReelsResponse> {
        return if (token.isEmpty()) {
            reelsApi.fetchInstagramReelsVideos(apiKey = apiKey)
        } else {
            reelsApi.fetchInstagramReelsVideos(apiKey = apiKey, token = token)
        }
    }
}
