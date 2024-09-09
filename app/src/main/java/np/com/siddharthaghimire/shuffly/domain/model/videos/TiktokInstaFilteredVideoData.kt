package np.com.siddharthaghimire.shuffly.domain.model.videos

data class TiktokInstaFilteredVideoData(
    val videoUrl: String,
    val thumbnail: String,
    val title: String?,
    val authorName: String,
    val authorPicture: String,
    val commentCount: Int,
    val likeCount: Int,
    val publishedTime: Int,
    val category: String
)
