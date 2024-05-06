package com.ereyes.chatrealtimedatabase.ui.adapters.chatAdapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ereyes.chatrealtimedatabase.common.Constants
import com.ereyes.chatrealtimedatabase.common.Constants.RECEIVED_MESSAGE
import com.ereyes.chatrealtimedatabase.common.Constants.SENT_MESSAGE
import com.ereyes.chatrealtimedatabase.databinding.ItemChatMeBinding
import com.ereyes.chatrealtimedatabase.databinding.ItemOtherChatBinding
import com.ereyes.chatrealtimedatabase.domain.model.MessageModel

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.ui.adapters.chatAdapter
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 1:12 PM
 * All rights reserved 2024.
 ****/
class ChatViewHolder(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    fun render(messageModel: MessageModel, itemViewType: Int) {
        when(itemViewType){
            SENT_MESSAGE -> {
                bindSentMessage(messageModel)
            }
            RECEIVED_MESSAGE -> {
                bindReceivedMessage(messageModel)
            }
        }
    }

    private fun bindReceivedMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemOtherChatBinding
        currentBinding.tvDate.text = messageModel.date
        currentBinding.tvHourMessage.text = messageModel.hour
        currentBinding.tvMessage.text = messageModel.message
        currentBinding.tvUser.text = messageModel.user.userName
    }

    private fun bindSentMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemChatMeBinding
        currentBinding.tvDate.text = messageModel.date
        currentBinding.tvHourMessage.text = messageModel.hour
        currentBinding.tvMessage.text = messageModel.message
    }

}