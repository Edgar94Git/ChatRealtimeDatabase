package com.ereyes.chatrealtimedatabase.data.network.response

import com.ereyes.chatrealtimedatabase.domain.model.UserModel

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.data.network.response
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 12:22 PM
 * All rights reserved 2024.
 ****/
data class UserResponse(val userName: String? = null, val admin: Boolean? = false)

fun UserResponse.toDomain(): UserModel {
    return UserModel(
        userName ?: "Guess",
        admin ?: false
    )
}