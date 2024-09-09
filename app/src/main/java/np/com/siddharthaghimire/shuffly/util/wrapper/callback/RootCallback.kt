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
package np.com.siddharthaghimire.shuffly.util.wrapper.callback

import android.view.View
import np.com.siddharthaghimire.shuffly.util.wrapper.CallbackType

interface RootCallback<T> {
    fun onRootCallback(index: Int, data: T?, type: CallbackType, view: View?) {}
}
