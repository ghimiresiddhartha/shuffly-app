package np.com.siddharthaghimire.shuffly.domain.model.videos.instagram

import np.com.siddharthaghimire.shuffly.domain.model.videos.TiktokInstaFilteredVideoData

data class InstagramFilteredData(
    val items: List<TiktokInstaFilteredVideoData>?,
    val total: Int
)
