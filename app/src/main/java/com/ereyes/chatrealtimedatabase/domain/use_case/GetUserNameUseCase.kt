package com.ereyes.chatrealtimedatabase.domain.use_case

import com.ereyes.chatrealtimedatabase.domain.DatabaseService
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.domain.use_case
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 3:15 PM
 * All rights reserved 2024.
 ****/
class GetUserNameUseCase @Inject constructor(private val databaseService: DatabaseService) {

    suspend operator fun invoke(): String {
        return databaseService.getUserName().first()
    }

}