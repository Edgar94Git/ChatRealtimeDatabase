package com.ereyes.chatrealtimedatabase.ui.chat

import androidx.lifecycle.ViewModel
import com.ereyes.chatrealtimedatabase.domain.use_case.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.ui.chat
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 9:39 AM
 * All rights reserved 2024.
 ****/

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase
): ViewModel() {

    fun sendMessage(){
        val message = "Hola"
        sendMessageUseCase(message)
    }

}