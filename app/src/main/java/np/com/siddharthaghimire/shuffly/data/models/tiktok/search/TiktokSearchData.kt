package np.com.siddharthaghimire.shuffly.data.models.tiktok.search

import np.com.siddharthaghimire.shuffly.data.models.tiktok.common.TiktokVideoData

data class TiktokSearchData(
    val cursor: Int?,
    val hasMore: Boolean,
    val videos: List<TiktokVideoData>
)