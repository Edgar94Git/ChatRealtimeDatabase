package com.ereyes.chatrealtimedatabase.ui.main

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.ui.main
 * Created by Edgar Reyes Gonzalez on 5/10/2024 at 11:06 AM
 * All rights reserved 2024.
 ****/
sealed class MainViewState {
    object LOADING: MainViewState()
    object UNREGISTER: MainViewState()
    object REGISTERED: MainViewState()
}