package com.ereyes.chatrealtimedatabase

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize
import dagger.hilt.android.HiltAndroidApp

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 9:33 AM
 * All rights reserved 2024.
 ****/

@HiltAndroidApp
class CharRealtimeDatabaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
    }
}