package np.com.siddharthaghimire.shuffly.data.models.youtube

data class YoutubeShortsResponse(
    val etag: String,
    val items: List<YoutubeItems>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: YoutubePageInfo,
    val regionCode: String
)