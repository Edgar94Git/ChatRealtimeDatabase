package com.ereyes.chatrealtimedatabase.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.chatrealtimedatabase.domain.use_case.GetUserNameUseCase
import com.ereyes.chatrealtimedatabase.domain.use_case.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.ui.main
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 9:40 AM
 * All rights reserved 2024.
 ****/

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
): ViewModel() {

    init {
        getUserName()
    }

    private val _uiState: MutableStateFlow<MainViewState> = MutableStateFlow(MainViewState.LOADING)
    val uiState: StateFlow<MainViewState> = _uiState

    fun saveUserName(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserNameUseCase(userName)
        }
    }

    private fun getUserName() {
        viewModelScope.launch {
            val userName = async { getUserNameUseCase() }.await()
            if(userName.isNotEmpty())
                _uiState.value = MainViewState.REGISTERED
            else
                _uiState.value = MainViewState.UNREGISTER
        }
    }

}