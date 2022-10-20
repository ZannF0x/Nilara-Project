package com.zannardy.nilaraproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zannardy.nilaraproject.model.NilaraConfig
import com.zannardy.nilaraproject.service.NilaraService
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    private var _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    fun callNilaraService(nilaraConfig: NilaraConfig) {
        viewModelScope.launch {
            try {
                NilaraService.buildRetrofit().initCall(nilaraConfig)
                _message.value = "SUCCESS"
            } catch (e : Exception) {
                e.printStackTrace()
                _message.value = "ERROR = ${e.message}"
            }
        }
    }
}