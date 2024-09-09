package np.com.siddharthaghimire.shuffly

import android.app.Application
import android.os.StrictMode
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory
import com.google.firebase.appcheck.ktx.appCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShufflyApp : Application() {

    private val lifecycleEventObserver = LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_START -> {
                isApplicationRunning = true
            }

            Lifecycle.Event.ON_STOP -> {
                isApplicationRunning = false
            }

            else -> {}
        }
    }

    companion object {
        var INSTANCE: Application = ShufflyApp()
        var isApplicationRunning = false
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)?.let {
            Firebase.appCheck(it).installAppCheckProviderFactory(
                if (BuildConfig.DEBUG) DebugAppCheckProviderFactory.getInstance()
                else PlayIntegrityAppCheckProviderFactory.getInstance()
            )
        }

        ProcessLifecycleOwner.get().lifecycle.addObserver(lifecycleEventObserver)
        INSTANCE = this@ShufflyApp

        if (BuildConfig.DEBUG) {
            /*StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDialog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )*/
        }
    }
}