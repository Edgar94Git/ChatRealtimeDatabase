package com.ereyes.chatrealtimedatabase.domain.model

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.domain.model
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 11:34 AM
 * All rights reserved 2024.
 ****/
data class MessageModel(
    val message: String,
    val hour: String,
    val date: String,
    val user: UserModel
)
