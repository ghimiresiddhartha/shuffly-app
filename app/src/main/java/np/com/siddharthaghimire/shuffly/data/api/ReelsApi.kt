package np.com.siddharthaghimire.shuffly.data.api

import np.com.siddharthaghimire.shuffly.data.models.instagram.InstagramReelsResponse
import np.com.siddharthaghimire.shuffly.BuildConfig.I_ENDPOINT
import np.com.siddharthaghimire.shuffly.BuildConfig.I_HASHTAG_SEARCH
import np.com.siddharthaghimire.shuffly.BuildConfig.HEADER_I
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