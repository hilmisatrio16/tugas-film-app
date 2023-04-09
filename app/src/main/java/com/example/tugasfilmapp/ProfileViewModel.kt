package com.example.tugasfilmapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private var _usernameProfile : MutableLiveData<String> = MutableLiveData()
    val usernameProfil : LiveData<String> get() = _usernameProfile

    fun setUsername(username : String){

        _usernameProfile.value = username

    }

}