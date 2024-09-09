/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package np.com.siddharthaghimire.shuffly.data.mappers

import np.com.siddharthaghimire.shuffly.data.models.instagram.InstagramReelsResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.search.TiktokSearchResponse
import np.com.siddharthaghimire.shuffly.data.models.tiktok.trending.TiktokTrendingResponse
import np.com.siddharthaghimire.shuffly.data.models.youtube.YoutubeShortsResponse
import np.com.siddharthaghimire.shuffly.domain.model.videos.TiktokInstaFilteredVideoData
import np.com.siddharthaghimire.shuffly.domain.model.videos.instagram.InstagramFilteredData
import np.com.siddharthaghimire.shuffly.domain.model.videos.instagram.InstagramFilteredResponse
import np.com.siddharthaghimire.shuffly.domain.model.videos.tiktok.TiktokFilteredData
import np.com.siddharthaghimire.shuffly.domain.model.videos.tiktok.TiktokFilteredResponse
import np.com.siddharthaghimire.shuffly.domain.model.videos.youtube.YoutubeFilteredItems
import np.com.siddharthaghimire.shuffly.domain.model.videos.youtube.YoutubeFilteredResponse
import np.com.siddharthaghimire.shuffly.util.AppConstants.FOR_YOU
import np.com.siddharthaghimire.shuffly.util.AppConstants.INSTAGRAM
import np.com.siddharthaghimire.shuffly.util.AppConstants.TRENDING
import np.com.siddharthaghimire.shuffly.util.AppConstants.YOUTUBE

fun YoutubeShortsResponse.toYoutubeResponse() = YoutubeFilteredResponse(
    items.map { item ->
        YoutubeFilteredItems(
            item.id.kind,
            item.id.videoId,
            item.snippet.publishedAt,
            item.snippet.title,
            item.snippet.channelTitle,
            item.snippet.thumbnails.high.url,
            YOUTUBE
        )
    },
    nextPageToken, pageInfo.totalResults, regionCode, null
)

fun TiktokSearchResponse.toTiktokForYouResponse() = TiktokFilteredResponse(
    msg, code,
    TiktokFilteredData(
        data?.cursor, data?.hasMore,
        data?.videos?.map { item ->
            TiktokInstaFilteredVideoData(
                item.play,
                item.cover,
                item.title,
                item.author.nickname,
                item.author.avatar,
                item.commentCount,
                item.diggCount,
                item.createTime,
                FOR_YOU
            )
        }
    )
)

fun TiktokTrendingResponse.toTiktokTrendingResponse() =
    TiktokFilteredResponse(
        msg, code,
        TiktokFilteredData(
            null, null,
            data.map { item ->
                TiktokInstaFilteredVideoData(
                    item.play,
                    item.cover,
                    item.title,
                    item.author.nickname,
                    item.author.avatar,
                    item.commentCount,
                    item.diggCount,
                    item.createTime,
                    TRENDING
                )
            }
        )
    )

fun InstagramReelsResponse.toInstagramResponse() =
    InstagramFilteredResponse(
        data = InstagramFilteredData(
            items = data.items.filter { item -> item.isVideo }
                .map { item ->
                    TiktokInstaFilteredVideoData(
                        item.videoVersions?.get(0)?.url ?: item.videoUrl.toString(),
                        item.thumbnailUrl,
                        item.caption.text,
                        item.caption.user.username,
                        item.caption.user.profilePicUrl,
                        item.commentCount,
                        item.likeCount,
                        item.caption.createdAtUtc,
                        INSTAGRAM
                    )
                },
            total = data.total
        ),
        token = paginationToken, message = null
    )
