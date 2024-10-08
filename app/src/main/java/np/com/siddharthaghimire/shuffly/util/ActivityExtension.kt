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
package np.com.siddharthaghimire.shuffly.util

import android.app.Activity
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

fun Activity.coloredStatusBarMode(color: Int, lightSystemUI: Boolean? = false) {
    val backgroundColour = ContextCompat.getColor(this, color)
    var flags: Int = window.decorView.systemUiVisibility // get current flags
    val systemLightUIFlag = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    var setSystemUILight = lightSystemUI

    if (setSystemUILight == null) {
        // Automatically check if the desired status bar is dark or light
        setSystemUILight = ColorUtils.calculateLuminance(backgroundColour) < 0.5
    }

    flags = if (setSystemUILight) {
        // Set System UI Dark (Battery Status Icon, Clock, etc)
        addFlag(flags, systemLightUIFlag)
    } else {
        // Set System UI Light (Battery Status Icon, Clock, etc)
        removeFlag(flags, systemLightUIFlag)
    }

    window.decorView.systemUiVisibility = flags
    window.statusBarColor = backgroundColour
}

private fun containsFlag(flags: Int, flagToCheck: Int) = (flags and flagToCheck) != 0

private fun addFlag(flags: Int, flagToAdd: Int): Int {
    return if (!containsFlag(flags, flagToAdd)) {
        flags or flagToAdd
    } else {
        flags
    }
}

private fun removeFlag(flags: Int, flagToRemove: Int): Int {
    return if (containsFlag(flags, flagToRemove)) {
        flags and flagToRemove.inv()
    } else {
        flags
    }
}

fun Activity.isGooglePlayServicesAvailable(): Boolean {
    val googleApiAvailability = GoogleApiAvailability.getInstance()
    val status = googleApiAvailability.isGooglePlayServicesAvailable(this)
    if (status != ConnectionResult.SUCCESS) {
        if (googleApiAvailability.isUserResolvableError(status)) {
            googleApiAvailability.getErrorDialog(this, status, 2404)?.show()
        }
        return false
    }
    return true
}
