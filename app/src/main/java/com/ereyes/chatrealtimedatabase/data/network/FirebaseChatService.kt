package com.ereyes.chatrealtimedatabase.data.network

import com.ereyes.chatrealtimedatabase.common.Constants.PATH
import com.ereyes.chatrealtimedatabase.data.network.dto.MessageDto
import com.ereyes.chatrealtimedatabase.data.network.response.MessageResponse
import com.ereyes.chatrealtimedatabase.data.network.response.toDomain
import com.ereyes.chatrealtimedatabase.domain.model.MessageModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.data.network
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 9:51 AM
 * All rights reserved 2024.
 ****/
class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {

    fun sendMessageToFirebase(message: MessageDto) {
        val newMessage: DatabaseReference = reference.child(PATH).push()
        newMessage.setValue(message)
    }

    fun getMessages(): Flow<List<MessageModel>> {
        return reference.child(PATH).snapshots.map { dataSnapshot ->
            dataSnapshot.children.mapNotNull {
                it.getValue(MessageResponse::class.java)?.toDomain()
            }
        }
    }
}