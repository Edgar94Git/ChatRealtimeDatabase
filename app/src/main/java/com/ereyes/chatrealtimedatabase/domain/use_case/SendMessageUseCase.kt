package com.ereyes.chatrealtimedatabase.domain.use_case

import com.ereyes.chatrealtimedatabase.data.network.FirebaseChatService
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
    operator fun invoke(message: String){
        firebaseChatService.sendMessageToFirebase(message)
    }
}