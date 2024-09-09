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

data class InstagramReelsItem(
    @SerializedName("are_remixes_crosspostable")
    val isCrossPostable: Boolean?,
    @SerializedName("boost_unavailable_identifier")
    val boostIdentifier: Any?,
    @SerializedName("boost_unavailable_reason")
    val boostUnavailableReason: Any?,
    @SerializedName("can_reshare")
    val canReShare: Boolean,
    @SerializedName("can_save")
    val canSave: Boolean,
    val caption: InstagramReelsCaption,
    @SerializedName("caption_is_edited")
    val captionIsEdited: Boolean,
    @SerializedName("carousel_media")
    val carouselMedia: List<Any>?,
    @SerializedName("carousel_media_count")
    val carouselMediaCount: Int?,
    @SerializedName("carousel_media_ids")
    val carouselMediaIds: List<Long>?,
    @SerializedName("carousel_media_pending_post_count")
    val carouselMediaPendingPostCount: Int?,
    @SerializedName("clips_delivery_parameters")
    val clipsDeliveryParameters: List<Any>?,
    @SerializedName("clips_metadata")
    val clipsMetadata: Any?,
    @SerializedName("clips_tab_pinned_user_ids")
    val clipsTabPinnedUserIds: List<Any>,
    @SerializedName("coauthor_producers")
    val coauthorProducers: List<Any>,
    val code: String,
    @SerializedName("collab_follow_button_info")
    val collabFollowButtonInfo: Any?,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("comment_inform_treatment")
    val commentInformTreatment: Any,
    @SerializedName("comment_likes_enabled")
    val commentLikesEnabled: Boolean?,
    @SerializedName("comment_threading_enabled")
    val commentThreadingEnabled: Boolean,
    @SerializedName("commerce_integrity_review_decision")
    val commerceIntegrityReviewDecision: String?,
    @SerializedName("commerciality_status")
    val commercialityStatus: String,
    @SerializedName("creative_config")
    val creativeConfig: Any?,
    @SerializedName("creator_viewer_insights")
    val creatorViewerInsights: List<Any>?,
    @SerializedName("crosspost")
    val crossPost: List<String>?,
    @SerializedName("deleted_reason")
    val deletedReason: Int,
    @SerializedName("device_timestamp")
    val deviceTimestamp: Long,
    @SerializedName("fb_aggregated_comment_count")
    val fbAggregatedCommentCount: Int,
    @SerializedName("fb_aggregated_like_count")
    val fbAggregatedLikeCount: Int,
    @SerializedName("fb_like_count")
    val fbLikeCount: Int?,
    @SerializedName("fb_play_count")
    val fbPlayCount: Int?,
    @SerializedName("fb_user_tags")
    val fbUserTags: Any,
    @SerializedName("fbid")
    val facebookId: String,
    @SerializedName("featured_products")
    val featuredProducts: List<Any>,
    @SerializedName("feed_type")
    val feedType: String,
    @SerializedName("filter_type")
    val filterType: Int,
    @SerializedName("fundraiser_tag")
    val fundraiserTag: Any,
    @SerializedName("has_audio")
    val hasAudio: Boolean?,
    @SerializedName("has_liked")
    val hasLiked: Boolean,
    @SerializedName("has_more_comments")
    val hasMoreComments: Boolean,
    @SerializedName("has_privately_liked")
    val hasPrivatelyLiked: Boolean,
    @SerializedName("has_shared_to_fb")
    val hasSharedToFb: Int,
    @SerializedName("highlights_info")
    val highlightsInfo: Any,
    @SerializedName("iab_post_click_data")
    val iabPostClickData: Any,
    val id: String,
    @SerializedName("ig_media_sharing_disabled")
    val igMediaSharingDisabled: Boolean,
    @SerializedName("image_versions")
    val imageVersions: Any,
    @SerializedName("integrity_review_decision")
    val integrityReviewDecision: String,
    @SerializedName("inventory_source")
    val inventorySource: String?,
    @SerializedName("invited_coauthor_producers")
    val invitedCoauthorProducers: List<Any>,
    @SerializedName("is_artist_pick")
    val isArtistPick: Boolean?,
    @SerializedName("is_auto_created")
    val isAutoCreated: Boolean,
    @SerializedName("is_comments_gif_composer_enabled")
    val isCommentsGifComposerEnabled: Boolean,
    @SerializedName("is_cutout_sticker_allowed")
    val isCutoutStickerAllowed: Boolean,
    @SerializedName("is_dash_eligible")
    val isDashEligible: Int?,
    @SerializedName("is_eligible_for_media_note_recs_nux")
    val isEligibleForMediaNoteRecsNux: Boolean,
    @SerializedName("is_in_profile_grid")
    val isInProfileGrid: Boolean,
    @SerializedName("is_open_to_public_submission")
    val isOpenToPublicSubmission: Boolean,
    @SerializedName("is_organic_product_tagging_eligible")
    val isOrganicProductTaggingEligible: Boolean,
    @SerializedName("is_paid_partnership")
    val isPaidPartnership: Boolean,
    @SerializedName("is_pinned")
    val isPinned: Boolean,
    @SerializedName("is_post_live_clips_media")
    val isPostLiveClipsMedia: Boolean,
    @SerializedName("is_reshare_of_text_post_app_media_in_ig")
    val isReShareOfTextPostAppMediaInIg: Boolean,
    @SerializedName("is_reuse_allowed")
    val isReuseAllowed: Boolean?,
    @SerializedName("is_tagged_media_shared_to_viewer_profile_grid")
    val isTaggedMediaSharedToViewerProfileGrid: Boolean,
    @SerializedName("is_third_party_downloads_eligible")
    val isThirdPartyDownloadsEligible: Boolean?,
    @SerializedName("is_unified_video")
    val isUnifiedVideo: Boolean,
    @SerializedName("is_video")
    val isVideo: Boolean,
    val lat: Double?,
    @SerializedName("layout_type")
    val layoutType: String,
    @SerializedName("like_and_view_counts_disabled")
    val likeAndViewCountsDisabled: Boolean,
    @SerializedName("like_count")
    val likeCount: Int,
    val lng: Double?,
    val location: Any?,
    @SerializedName("max_num_visible_preview_comments")
    val maxNumVisiblePreviewComments: Int,
    @SerializedName("media_cropping_info")
    val mediaCroppingInfo: Any?,
    @SerializedName("media_name")
    val mediaName: String,
    @SerializedName("media_type")
    val mediaType: Int,
    @SerializedName("mezql_token")
    val mezqlToken: String,
    @SerializedName("music_metadata")
    val musicMetadata: Any?,
    @SerializedName("next_max_id")
    val nextMaxId: Long?,
    @SerializedName("number_of_qualities")
    val numberOfQualities: Int?,
    @SerializedName("open_carousel_submission_state")
    val openCarouselSubmissionState: String?,
    @SerializedName("original_height")
    val originalHeight: Int,
    @SerializedName("original_width")
    val originalWidth: Int,
    val owner: Any,
    val pk: Long,
    @SerializedName("play_count")
    val playCount: Int?,
    @SerializedName("preview_comments")
    val previewComments: List<Any>,
    @SerializedName("product_suggestions")
    val productSuggestions: List<Any>,
    @SerializedName("product_type")
    val productType: String,
    @SerializedName("reshare_count")
    val reShareCount: Int?,
    @SerializedName("share_count_disabled")
    val shareCountDisabled: Boolean,
    @SerializedName("sharing_friction_info")
    val sharingFrictionInfo: Any,
    @SerializedName("shop_routing_user_id")
    val shopRoutingUserId: Any?,
    @SerializedName("should_show_author_pog_for_tagged_media_shared_to_profile_grid")
    val shouldShowAuthorPogForTaggedMediaSharedToProfileGrid: Boolean,
    @SerializedName("social_context")
    val socialContext: List<Any>?,
    @SerializedName("subscribe_cta_visible")
    val subscribeCtaVisible: Boolean,
    @SerializedName("tagged_users")
    val taggedUsers: Any?,
    @SerializedName("taken_at")
    val takenAt: Int,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("top_likers")
    val topLikers: List<String>,
    val user: Any,
    @SerializedName("video_codec")
    val videoCodec: String?,
    @SerializedName("video_duration")
    val videoDuration: Double?,
    @SerializedName("video_subtitles_confidence")
    val videoSubtitlesConfidence: Double?,
    @SerializedName("video_subtitles_locale")
    val videoSubtitlesLocale: String?,
    @SerializedName("video_url")
    val videoUrl: String?,
    @SerializedName("video_versions")
    val videoVersions: List<InstagramReelsVideoVersion>?,
    @SerializedName("view_state_item_type")
    val viewStateItemType: Int?
)
