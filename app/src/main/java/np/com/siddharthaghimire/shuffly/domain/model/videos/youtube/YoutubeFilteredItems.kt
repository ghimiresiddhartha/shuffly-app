package np.com.siddharthaghimire.shuffly.domain.model.videos.youtube

data class YoutubeFilteredItems(
    val videoKind: String?,
    val videoId: String?,
    val publishedAt: String,
    val title: String,
    val channelTitle: String,
    val thumbnailUrl: String,
    val category: String
)
