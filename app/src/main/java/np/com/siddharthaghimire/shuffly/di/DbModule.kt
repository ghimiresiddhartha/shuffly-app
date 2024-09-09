package np.com.siddharthaghimire.shuffly.di

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import np.com.siddharthaghimire.shuffly.BuildConfig
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Singleton
    @Provides
    @Named("shared")
    fun provideSharedPreference(
        @ApplicationContext context: Context
    ): SharedPreferences {
        return context.getSharedPreferences(
            BuildConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    @Named("key")
    fun provideApiKeyDatabaseReference(): DatabaseReference =
        FirebaseDatabase.getInstance().getReference(BuildConfig.FIREBASE_ENTITY)

    @Singleton
    @Provides
    @Named("network")
    fun provideNetworkDatabaseReference(): DatabaseReference =
        FirebaseDatabase.getInstance().getReference(".info/connected")

}