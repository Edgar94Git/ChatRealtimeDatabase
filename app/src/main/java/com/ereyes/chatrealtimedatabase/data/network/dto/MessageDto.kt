package com.ereyes.chatrealtimedatabase.data.network.dto

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.data.network.dto
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 11:33 AM
 * All rights reserved 2024.
 ****/
data class MessageDto(
    val message: String,
    val hour: String,
    val date: String,
    val user: UserDto
)