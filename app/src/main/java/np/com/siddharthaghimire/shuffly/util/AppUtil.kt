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

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.telephony.TelephonyManager
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Objects
import java.util.TimeZone
import kotlin.math.pow
import np.com.siddharthaghimire.shuffly.ShufflyApp

object AppUtil {
    fun changeDeviceBarColor(decorView: View, color: Int) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            var flags = decorView.systemUiVisibility
            flags = if (isColorLight(color)) {
                flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                flags and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
            }
            decorView.systemUiVisibility = flags
        }
    }

    fun dpToPx(context: Context, dp: Int): Int {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return (dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    fun isConnection(): Boolean {
        val connectivityManager =
            ShufflyApp.INSTANCE.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = Objects.requireNonNull(connectivityManager).activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    private fun isColorLight(color: Int): Boolean {
        val darkness =
            1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return darkness < 0.5
    }

    inline fun Context.cameraPermissionRequest(crossinline positive: () -> Unit) {
        AlertDialog.Builder(this).setTitle("Camera Permission Required")
            .setMessage("Without accessing the camera it is not possible to capture.")
            .setPositiveButton("Allow Camera") { _, _ ->
                positive.invoke()
            }.setNegativeButton("Cancel") { _, _ ->
            }.show()
    }

    fun Context.openPermissionSetting() {
        Intent(ACTION_APPLICATION_DETAILS_SETTINGS).also {
            val uri: Uri = Uri.fromParts("package", packageName, null)
            it.data = uri
            startActivity(it)
        }
    }

    fun Context.isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this, permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun Context.haveStoragePermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_MEDIA_IMAGES
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun Activity.requestStoragePermission() {
        if (!haveStoragePermission()) {
            this.requestPermissions(
                permissions(), 101
            )
        }
    }

    private fun permissions(): Array<String> {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            storage_permissions_33
        } else {
            storage_permissions
        }
    }

    var storage_permissions = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    var storage_permissions_33 = arrayOf(
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.READ_MEDIA_AUDIO,
        Manifest.permission.READ_MEDIA_VIDEO
    )

    fun getCurrentRegionCode(context: Context): String {
        val telephonyManager =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        var regionCode: String? = telephonyManager.simCountryIso
        Log.d(
            "TIGER", "getCurrentRegionCode: networkCountry: " + telephonyManager.networkCountryIso
        )
        Log.d("TIGER", "getCurrentRegionCode: isVpnActive: " + isVpnActive(context))
        if (regionCode.isNullOrEmpty()) {
            regionCode = telephonyManager.networkCountryIso
        }
        return regionCode?.lowercase(Locale.getDefault()) ?: "us"
    }

    fun isVpnActive(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networks = connectivityManager.allNetworks
        for (network in networks) {
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
            if (networkCapabilities != null && networkCapabilities.hasTransport(
                    NetworkCapabilities.TRANSPORT_VPN
                )
            ) {
                return true
            }
        }
        return false
    }

    fun convertTimestampToReadableDate(
        stringTimestamp: String?,
        unixTimeStamp: Long?,
        pattern: String?
    ): String {
        val inputFormat = stringTimestamp?.let {
            SimpleDateFormat(pattern, Locale.US)
        }
        inputFormat?.timeZone = TimeZone.getTimeZone("UTC")
        val outputFormat = SimpleDateFormat("d MMM", Locale.US)
        outputFormat.timeZone = TimeZone.getDefault()
        val date: Date =
            inputFormat?.parse(stringTimestamp) ?: run { Date(unixTimeStamp?.times(1000) ?: 0) }
        return outputFormat.format(date)
    }

    fun formatNumberWithSuffix(number: Long): String {
        if (number < 1000) return number.toString()

        val suffixes = arrayOf("", "K", "M", "B", "T")
        val value = number.toString()
        val length = value.length

        val exponent = (length - 1) / 3
        val suffix = suffixes[exponent]

        val base = 10.0.pow((exponent * 3).toDouble()).toLong()
        val roundedNumber = number / base
        return "${roundedNumber}$suffix"
    }
}
