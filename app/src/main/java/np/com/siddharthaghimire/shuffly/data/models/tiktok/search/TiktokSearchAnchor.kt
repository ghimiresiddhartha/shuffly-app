package np.com.siddharthaghimire.shuffly.data.models.tiktok.search

import com.google.gson.annotations.SerializedName

data class TiktokSearchAnchor(
    val actions: List<TitktokSearchAction>,
    @SerializedName("component_key")
    val componentKey: String,
    val description: String,
    val extra: String,
    val icon: TiktokSearchIconX,
    val id: String,
    val keyword: String,
    @SerializedName("log_extra")
    val logExtra: String,
    val thumbnail: TiktokSearchThumbnail,
    val type: Int
)