package np.com.siddharthaghimire.shuffly.domain.repository

import np.com.siddharthaghimire.shuffly.data.api.ReelsApi
import np.com.siddharthaghimire.shuffly.data.api.ShortsApi
import np.com.siddharthaghimire.shuffly.data.api.TiktokApi
import np.com.siddharthaghimire.shuffly.data.models.instagram.InstagramReelsResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.search.TiktokSearchResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.trending.TiktokTrendingResponse
import np.com.siddharthaghimire.shuffly.data.models.youtube.YoutubeShortsResponse
import retrofit2.Response
import javax.inject.Inject

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
        }
        else {
            reelsApi.fetchInstagramReelsVideos(apiKey = apiKey, token = token)
        }
    }
}