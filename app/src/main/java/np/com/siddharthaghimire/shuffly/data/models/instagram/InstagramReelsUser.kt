package np.com.siddharthaghimire.shuffly.data.models.instagram

import com.google.gson.annotations.SerializedName

data class InstagramReelsUser(
    @SerializedName("fbid_v2")
    val facebookIdV2: Long,
    @SerializedName("full_name")
    val fullName: String,
    val id: String,
    @SerializedName("is_private")
    val isPrivate: Boolean,
    @SerializedName("is_verified")
    val isVerified: Boolean,
    @SerializedName("profile_pic_id")
    val profilePicId: String,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String,
    val username: String
)