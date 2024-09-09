package np.com.siddharthaghimire.shuffly.data.api

import np.com.siddharthaghimire.shuffly.data.models.youtube.YoutubeShortsResponse
import np.com.siddharthaghimire.shuffly.BuildConfig.MAX_RESULT
import np.com.siddharthaghimire.shuffly.BuildConfig.SEARCH_ENDPOINT
import np.com.siddharthaghimire.shuffly.BuildConfig.Y_ID
import np.com.siddharthaghimire.shuffly.BuildConfig.Y_SHOULD_EMBED
import np.com.siddharthaghimire.shuffly.BuildConfig.Y_SHOULD_SYNDICATE
import np.com.siddharthaghimire.shuffly.BuildConfig.Y_SORT_BY
import np.com.siddharthaghimire.shuffly.BuildConfig.Y_TYPE
import np.com.siddharthaghimire.shuffly.BuildConfig.Y_VIDEO_LENGTH
import np.com.siddharthaghimire.shuffly.BuildConfig.Y_VIDEO_TYPE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShortsApi {
    @GET(SEARCH_ENDPOINT)
    suspend fun fetchYoutubeShorts(
        @Query("key") key: String,
        @Query("part") part: String = Y_ID,
        @Query("type") type: String = Y_TYPE,
        @Query("order") order: String = Y_SORT_BY,
        @Query("videoSyndicated") videoSyndicated: Boolean = Y_SHOULD_SYNDICATE,
        @Query("videoDuration") videoDuration: String = Y_VIDEO_LENGTH,
        @Query("videoEmbeddable") videoEmbeddable: Boolean = Y_SHOULD_EMBED,
        @Query("q") query: String = Y_VIDEO_TYPE,
        @Query("maxResults") totalItemsPerPage: Int = MAX_RESULT,
        @Query("pageToken") token: String
    ): Response<YoutubeShortsResponse>
}