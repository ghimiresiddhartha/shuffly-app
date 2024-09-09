package np.com.siddharthaghimire.shuffly.data.models.tiktok.search

import com.google.gson.annotations.SerializedName

data class TiktokSearchResponse(
    val code: Int?,
    val data: TiktokSearchData?,
    var msg: String?,
    @SerializedName("processed_time")
    val processedTime: Double
)