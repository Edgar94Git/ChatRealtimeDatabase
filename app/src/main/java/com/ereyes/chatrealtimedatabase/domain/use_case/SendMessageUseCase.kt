package com.ereyes.chatrealtimedatabase.domain.use_case

import android.icu.util.Calendar
import com.ereyes.chatrealtimedatabase.common.getDateFormat
import com.ereyes.chatrealtimedatabase.common.getHourMin
import com.ereyes.chatrealtimedatabase.common.getMonthName
import com.ereyes.chatrealtimedatabase.data.network.FirebaseChatService
import com.ereyes.chatrealtimedatabase.data.network.dto.MessageDto
import com.ereyes.chatrealtimedatabase.data.network.dto.UserDto
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.domain.use_case
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 9:44 AM
 * All rights reserved 2024.
 ****/
class SendMessageUseCase @Inject constructor(
    private val firebaseChatService: FirebaseChatService
) {
    operator fun invoke(message: String, userName: String){

        val messageDto = MessageDto(
            message,
            getHourMin(),
            getDateFormat(),
            UserDto(
                userName,
                false
            )
        )

        firebaseChatService.sendMessageToFirebase(messageDto)
    }
}