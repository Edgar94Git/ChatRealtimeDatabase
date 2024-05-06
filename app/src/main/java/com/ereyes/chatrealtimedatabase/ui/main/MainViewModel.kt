package com.ereyes.chatrealtimedatabase.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.chatrealtimedatabase.domain.use_case.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    fun saveUserName(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserNameUseCase(userName)
        }
    }

}