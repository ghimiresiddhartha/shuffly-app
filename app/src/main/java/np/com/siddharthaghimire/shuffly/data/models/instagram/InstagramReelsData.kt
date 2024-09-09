package np.com.siddharthaghimire.shuffly.data.models.instagram

import com.google.gson.annotations.SerializedName

data class InstagramReelsData(
    @SerializedName("additional_data")
    val additionalData: Any,
    val count: Int,
    val items: List<InstagramReelsItem>,
    val total: Int
)