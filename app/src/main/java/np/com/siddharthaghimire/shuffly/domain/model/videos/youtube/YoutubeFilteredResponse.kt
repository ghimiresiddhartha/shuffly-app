package np.com.siddharthaghimire.shuffly.domain.model.videos.youtube

data class YoutubeFilteredResponse(
    val items: List<YoutubeFilteredItems>? = null,
    val nextPageToken: String? = null,
    val totalResults: Int? = null,
    val regionCode: String? = null,
    val message: String? = null
)
