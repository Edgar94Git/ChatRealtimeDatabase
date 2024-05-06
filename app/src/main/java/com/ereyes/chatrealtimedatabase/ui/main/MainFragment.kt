package com.ereyes.chatrealtimedatabase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ereyes.chatrealtimedatabase.R
import com.ereyes.chatrealtimedatabase.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

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
            findNavController().navigate(R.id.action_mainFragment_to_chatFragment)
        }
    }

}