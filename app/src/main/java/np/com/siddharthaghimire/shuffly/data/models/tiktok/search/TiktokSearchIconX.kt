package np.com.siddharthaghimire.shuffly.data.models.tiktok.search

import com.google.gson.annotations.SerializedName

data class TiktokSearchIconX(
    val height: Int,
    val uri: String,
    @SerializedName("url_list")
    val urlList: List<String>,
    @SerializedName("url_prefix")
    val urlPrefix: Any,
    val width: Int
)