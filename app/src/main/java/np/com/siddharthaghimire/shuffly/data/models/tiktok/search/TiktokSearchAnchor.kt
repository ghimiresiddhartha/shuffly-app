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
package np.com.siddharthaghimire.shuffly.data.models.tiktok.search

import com.google.gson.annotations.SerializedName

data class TiktokSearchAnchor(
    val actions: List<TitktokSearchAction>,
    @SerializedName("component_key")
    val componentKey: String,
    val description: String,
    val extra: String,
    val icon: TiktokSearchIconX,
    val id: String,
    val keyword: String,
    @SerializedName("log_extra")
    val logExtra: String,
    val thumbnail: TiktokSearchThumbnail,
    val type: Int
)
