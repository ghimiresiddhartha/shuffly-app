package np.com.siddharthaghimire.shuffly.data.models.tiktok.trending

import com.google.gson.annotations.SerializedName
import np.com.siddharthaghimire.shuffly.data.models.tiktok.common.TiktokVideoData

data class TiktokTrendingResponse(
    val code: Int,
    val data: List<TiktokVideoData>,
    val msg: String,
    @SerializedName("processed_time")
    val processedTime: Double
)