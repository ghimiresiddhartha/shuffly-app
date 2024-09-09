package np.com.siddharthaghimire.shuffly.data.models.instagram

import com.google.gson.annotations.SerializedName

data class InstagramReelsCaption(
    @SerializedName("content_type")
    val contentType: String,
    @SerializedName("created_at")
    val createdAt: Int,
    @SerializedName("created_at_utc")
    val createdAtUtc: Int,
    @SerializedName("did_report_as_spam")
    val didReportAsSpam: Boolean,
    @SerializedName("has_translation")
    val hasTranslation: Boolean,
    val hashtags: List<String?>?,
    val id: Long,
    @SerializedName("is_covered")
    val isCovered: Boolean,
    @SerializedName("is_ranked_comment")
    val isRankedComment: Boolean,
    val mentions: List<String?>?,
    val pk: String,
    @SerializedName("private_reply_status")
    val privateReplyStatus: Int,
    @SerializedName("share_enabled")
    val shareEnabled: Boolean,
    val status: String,
    val text: String,
    val type: Int,
    val user: InstagramReelsUser,
    @SerializedName("user_id")
    val userId: Long
)