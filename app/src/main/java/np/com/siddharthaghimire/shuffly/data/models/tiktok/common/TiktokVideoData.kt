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
package np.com.siddharthaghimire.shuffly.data.models.tiktok.common

import com.google.gson.annotations.SerializedName

data class TiktokVideoData(
    @SerializedName("ai_dynamic_cover")
    val aiDynamicCover: String,
    val anchors: Any?,
    @SerializedName("anchors_extras")
    val anchorsExtras: String,
    val author: TiktokAuthor,
    @SerializedName("aweme_id")
    val awemeId: String,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("commercial_video_info")
    val commercialVideoInfo: String,
    val cover: String,
    @SerializedName("create_time")
    val createTime: Int,
    @SerializedName("digg_count")
    val diggCount: Int,
    @SerializedName("download_count")
    val downloadCount: Int,
    val duration: Int,
    @SerializedName("is_ad")
    val isAd: Boolean,
    @SerializedName("is_top")
    val isTop: Int,
    @SerializedName("item_comment_settings")
    val itemCommentSettings: Int,
    val music: String,
    @SerializedName("music_info")
    val musicInfo: TiktokMusicInfo,
    @SerializedName("origin_cover")
    val originCover: String,
    val play: String,
    @SerializedName("play_count")
    val playCount: Int,
    val region: String,
    @SerializedName("share_count")
    val shareCount: Int,
    val title: String?,
    @SerializedName("video_id")
    val videoId: String,
    @SerializedName("wmplay")
    val wmPlay: String
)
