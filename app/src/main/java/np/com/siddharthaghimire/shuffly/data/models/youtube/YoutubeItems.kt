package np.com.siddharthaghimire.shuffly.data.models.youtube

data class YoutubeItems(
    val etag: String,
    val id: YoutubeVideoInfo,
    val kind: String,
    val snippet: YoutubeSnippet
)