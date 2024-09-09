package np.com.siddharthaghimire.shuffly.data.models.tiktok.search

import com.google.gson.annotations.SerializedName

data class TitktokSearchAction(
    @SerializedName("action_type")
    val actionType: Int,
    val icon: TiktokSearchIconX,
    val schema: String
)