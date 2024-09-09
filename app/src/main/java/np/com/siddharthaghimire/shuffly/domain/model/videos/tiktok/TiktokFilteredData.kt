package np.com.siddharthaghimire.shuffly.domain.model.videos.tiktok

import np.com.siddharthaghimire.shuffly.domain.model.videos.TiktokInstaFilteredVideoData

data class TiktokFilteredData(
    val pageCount: Int?,
    val hasMoreVideos: Boolean?,
    val videos: List<TiktokInstaFilteredVideoData>?
)
