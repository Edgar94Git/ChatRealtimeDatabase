package com.ereyes.chatrealtimedatabase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ereyes.chatrealtimedatabase.R
import com.ereyes.chatrealtimedatabase.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOnClickListener()
    }

    private fun setUpOnClickListener() {
        binding.btnChat.setOnClickListener {
            val userName = binding.tvUserName.text.toString().trim()
            if(userName.isNotEmpty()){
                viewModel.saveUserName(userName)
                findNavController().navigate(R.id.action_mainFragment_to_chatFragment)
            }
        }
    }

}