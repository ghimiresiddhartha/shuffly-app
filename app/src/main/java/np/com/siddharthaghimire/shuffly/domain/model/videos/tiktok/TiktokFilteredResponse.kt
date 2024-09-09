package np.com.siddharthaghimire.shuffly.domain.model.videos.tiktok

data class TiktokFilteredResponse(
    var message: String? = null,
    var code: Int? = null,
    val data: TiktokFilteredData? = null
)
