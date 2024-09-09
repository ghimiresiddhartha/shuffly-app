package np.com.siddharthaghimire.shuffly.di

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class LifecycleScopeModule {
    @Provides
    fun getLifecycleScope(activity: Activity): Lifecycle {
        return (activity as LifecycleOwner).lifecycle
    }
}