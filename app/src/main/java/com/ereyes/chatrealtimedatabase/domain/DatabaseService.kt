package com.ereyes.chatrealtimedatabase.domain

import kotlinx.coroutines.flow.Flow

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.domain
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 2:46 PM
 * All rights reserved 2024.
 ****/
interface DatabaseService {

    suspend fun saveUserName(userName: String)
    fun getUserName(): Flow<String>
}