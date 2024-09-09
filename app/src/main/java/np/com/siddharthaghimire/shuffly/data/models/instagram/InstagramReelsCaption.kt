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
package np.com.siddharthaghimire.shuffly.data.models.instagram

import com.google.gson.annotations.SerializedName

data class InstagramReelsCaption(
    @SerializedName("content_type")
    val contentType: String,
    @SerializedName("created_at")
    val createdAt: Int,
    @SerializedName("created_at_utc")
    val createdAtUtc: Int,
    @SerializedName("did_report_as_spam")
    val didReportAsSpam: Boolean,
    @SerializedName("has_translation")
    val hasTranslation: Boolean,
    val hashtags: List<String?>?,
    val id: Long,
    @SerializedName("is_covered")
    val isCovered: Boolean,
    @SerializedName("is_ranked_comment")
    val isRankedComment: Boolean,
    val mentions: List<String?>?,
    val pk: String,
    @SerializedName("private_reply_status")
    val privateReplyStatus: Int,
    @SerializedName("share_enabled")
    val shareEnabled: Boolean,
    val status: String,
    val text: String,
    val type: Int,
    val user: InstagramReelsUser,
    @SerializedName("user_id")
    val userId: Long
)
