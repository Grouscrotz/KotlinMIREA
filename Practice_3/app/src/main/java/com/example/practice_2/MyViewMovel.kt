package com.example.practice_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewMovel : ViewModel() {
    var liveData = MutableLiveData<String>()

    fun changeString(string: String) {
        liveData.value = string
    }
}