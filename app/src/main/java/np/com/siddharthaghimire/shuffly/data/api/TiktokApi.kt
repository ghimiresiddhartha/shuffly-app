package np.com.siddharthaghimire.shuffly.data.api

import np.com.siddharthaghimire.shuffly.data.models.tiktok.search.TiktokSearchResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.trending.TiktokTrendingResponse
import np.com.siddharthaghimire.shuffly.BuildConfig.MAX_RESULT
import np.com.siddharthaghimire.shuffly.BuildConfig.SEARCH_ENDPOINT
import np.com.siddharthaghimire.shuffly.BuildConfig.HEADER_T
import np.com.siddharthaghimire.shuffly.BuildConfig.T_SEARCH_KEYWORD
import np.com.siddharthaghimire.shuffly.BuildConfig.T_TRENDING_ENDPOINT
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
    ):Response<TiktokTrendingResponse>

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
    ):Response<TiktokSearchResponse>
}