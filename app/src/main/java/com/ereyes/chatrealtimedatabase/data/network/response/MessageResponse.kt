package com.ereyes.chatrealtimedatabase.data.network.response

import com.ereyes.chatrealtimedatabase.domain.model.MessageModel
import com.ereyes.chatrealtimedatabase.domain.model.UserModel

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.data.network.response
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 12:21 PM
 * All rights reserved 2024.
 ****/
data class MessageResponse(
    val message: String? = null,
    val hour: String? = null,
    val date: String? = null,
    val user: UserResponse? = null
)

fun MessageResponse.toDomain(): MessageModel {
    return MessageModel(
        message.orEmpty(),
        hour.orEmpty(),
        date.orEmpty(),
        user?.toDomain() ?: UserModel(userName = "Guess", admin = false)
    )
}
