package com.ereyes.chatrealtimedatabase.data.network.database

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ereyes.chatrealtimedatabase.common.Constants
import com.ereyes.chatrealtimedatabase.common.Constants.DATA_BASE
import com.ereyes.chatrealtimedatabase.common.Constants.USER_NAME
import com.ereyes.chatrealtimedatabase.domain.DatabaseService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.data.network.database
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 2:48 PM
 * All rights reserved 2024.
 ****/
class DatabaseServiceImpl @Inject constructor(private val context: Context): DatabaseService {

    private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
        name = DATA_BASE
    )

    override suspend fun saveUserName(userName: String) {
        context.userPreferencesDataStore.edit { preferences ->
            preferences[stringPreferencesKey(USER_NAME)] = userName
        }
    }

    override fun getUserName(): Flow<String> {
        return context.userPreferencesDataStore.data.map { preferences ->  preferences[stringPreferencesKey(USER_NAME)] ?: ""}
    }
}