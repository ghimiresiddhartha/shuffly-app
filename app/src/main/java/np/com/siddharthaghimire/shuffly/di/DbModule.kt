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
import javax.inject.Named
import javax.inject.Singleton
import np.com.siddharthaghimire.shuffly.BuildConfig

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
