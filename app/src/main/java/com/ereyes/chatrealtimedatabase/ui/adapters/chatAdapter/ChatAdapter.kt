package com.ereyes.chatrealtimedatabase.ui.adapters.chatAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.chatrealtimedatabase.common.Constants.RECEIVED_MESSAGE
import com.ereyes.chatrealtimedatabase.common.Constants.SENT_MESSAGE
import com.ereyes.chatrealtimedatabase.databinding.ItemChatMeBinding
import com.ereyes.chatrealtimedatabase.databinding.ItemOtherChatBinding
import com.ereyes.chatrealtimedatabase.domain.model.MessageModel

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.ui.adapters.chatAdapter
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 1:11 PM
 * All rights reserved 2024.
 ****/
class ChatAdapter(
    var messagesList: MutableList<MessageModel> = mutableListOf(),
    var userName: String = "Guess"
): RecyclerView.Adapter<ChatViewHolder>() {

    fun updateListMessages(newMessagesList: MutableList<MessageModel>) {
        messagesList.clear()
        messagesList.addAll(newMessagesList)
        notifyItemInserted(messagesList.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = when(viewType) {
            SENT_MESSAGE -> {
                ItemChatMeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            RECEIVED_MESSAGE -> {
                ItemOtherChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            else -> {
                ItemChatMeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
        }

        return ChatViewHolder(binding)
    }

    override fun getItemCount(): Int = messagesList.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.render(messagesList[position], getItemViewType(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if(messagesList[position].user.userName == userName) SENT_MESSAGE else RECEIVED_MESSAGE
    }
}