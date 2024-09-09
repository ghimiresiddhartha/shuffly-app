package np.com.siddharthaghimire.shuffly.data.models.instagram

import com.google.gson.annotations.SerializedName
import np.com.siddharthaghimire.shuffly.data.models.instagram.InstagramReelsData

data class InstagramReelsResponse(
    val data: InstagramReelsData,
    @SerializedName("pagination_token")
    val paginationToken: String
)