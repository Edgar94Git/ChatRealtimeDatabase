package com.ereyes.chatrealtimedatabase.data.network

import com.ereyes.chatrealtimedatabase.common.Constants.PATH
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.data.network
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 9:51 AM
 * All rights reserved 2024.
 ****/
class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {

    fun sendMessageToFirebase(message: String) {
        val newMessage: DatabaseReference = reference.child(PATH).push()
        newMessage.setValue(message)
    }
}