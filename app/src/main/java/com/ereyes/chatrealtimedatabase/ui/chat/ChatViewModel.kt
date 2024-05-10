package com.ereyes.chatrealtimedatabase.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.chatrealtimedatabase.domain.model.MessageModel
import com.ereyes.chatrealtimedatabase.domain.use_case.GetMessagesUseCase
import com.ereyes.chatrealtimedatabase.domain.use_case.GetUserNameUseCase
import com.ereyes.chatrealtimedatabase.domain.use_case.SaveUserNameUseCase
import com.ereyes.chatrealtimedatabase.domain.use_case.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.ui.chat
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 9:39 AM
 * All rights reserved 2024.
 ****/

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val getMessagesUseCase: GetMessagesUseCase,
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    private var _userName: MutableLiveData<String> = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private var _messageList = MutableStateFlow<List<MessageModel>>(emptyList())
    val messageList: StateFlow<List<MessageModel>> = _messageList

    init {
        getUserName()
        getMessages()
    }

    private fun getMessages(){
        viewModelScope.launch {
            getMessagesUseCase().collect{
                _messageList.value = it
            }
        }
    }

    fun sendMessage(message: String, userName: String){
        sendMessageUseCase(message, userName)
    }

    private fun getUserName(){
        viewModelScope.launch(Dispatchers.IO) {
            val userName = getUserNameUseCase()
            _userName.postValue(userName)
        }
    }

    fun logout(onViewFinish: () -> Unit){
        viewModelScope.launch{
            async { saveUserNameUseCase("") }.await()
            onViewFinish()
        }
    }

}