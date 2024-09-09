package np.com.siddharthaghimire.shuffly.data.models.youtube

data class YoutubeSnippet(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnails: YoutubeThumbnailInfo,
    val channelTitle: String,
    val liveBroadcastContent: String,
    val publishTime: String
)
