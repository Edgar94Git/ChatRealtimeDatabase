package com.ereyes.chatrealtimedatabase.di

import com.ereyes.chatrealtimedatabase.data.network.FirebaseChatService
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.di
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 10:00 AM
 * All rights reserved 2024.
 ****/

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabaseReference(): DatabaseReference {
        return Firebase.database.reference
    }

    @Provides
    @Singleton
    fun provideFirebaseChatService(reference: DatabaseReference) = FirebaseChatService(reference)

}