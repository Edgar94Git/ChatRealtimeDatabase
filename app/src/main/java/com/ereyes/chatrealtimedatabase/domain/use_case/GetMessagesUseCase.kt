package com.ereyes.chatrealtimedatabase.domain.use_case

import com.ereyes.chatrealtimedatabase.data.network.FirebaseChatService
import com.ereyes.chatrealtimedatabase.domain.model.MessageModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.domain.use_case
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 12:32 PM
 * All rights reserved 2024.
 ****/
class GetMessagesUseCase @Inject constructor(
    private val firebaseChatService: FirebaseChatService
) {

    operator fun invoke(): Flow<List<MessageModel>> {
        return firebaseChatService.getMessages()
    }

}