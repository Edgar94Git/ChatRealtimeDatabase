package com.ereyes.chatrealtimedatabase.domain.use_case

import com.ereyes.chatrealtimedatabase.domain.DatabaseService
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.domain.use_case
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 2:34 PM
 * All rights reserved 2024.
 ****/
class SaveUserNameUseCase @Inject constructor(
    private val databaseService: DatabaseService
) {

    suspend operator fun invoke(userName: String) {
        databaseService.saveUserName(userName)
    }

}