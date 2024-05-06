package com.ereyes.chatrealtimedatabase.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ereyes.chatrealtimedatabase.R
import com.ereyes.chatrealtimedatabase.databinding.FragmentChatBinding
import com.ereyes.chatrealtimedatabase.ui.adapters.chatAdapter.ChatAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val viewModel by viewModels<ChatViewModel>()
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        setUpAdapter()
        setUpOnClickListener()
        subscribeToMessages()
    }

    private fun setUpObserver() {
        viewModel.userName.observe(viewLifecycleOwner) { userName ->
            chatAdapter.userName = userName
        }
    }

    private fun setUpAdapter() {
        chatAdapter = ChatAdapter()
        binding.rvMessages.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun subscribeToMessages() {
        lifecycleScope.launch {
            viewModel.messageList.collect{ messagesList ->
                chatAdapter.updateListMessages(messagesList.toMutableList())
                binding.rvMessages.scrollToPosition(chatAdapter.messagesList.size - 1)
            }
        }
    }

    private fun setUpOnClickListener() {
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_chatFragment_to_mainFragment)
        }
        binding.btnSend.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val message = binding.etMessage.text.toString().trim()
        if(message.isNotEmpty()){
            viewModel.sendMessage(message, chatAdapter.userName)
            binding.etMessage.setText("")
        }
    }
}