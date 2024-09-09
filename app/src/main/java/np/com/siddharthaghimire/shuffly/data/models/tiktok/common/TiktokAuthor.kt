package np.com.siddharthaghimire.shuffly.data.models.tiktok.common

import com.google.gson.annotations.SerializedName

data class TiktokAuthor(
    val avatar: String,
    val id: String,
    val nickname: String,
    @SerializedName("unique_id")
    val uniqueId: String,
    @SerializedName("is_top")
    val isTop: Int?
)