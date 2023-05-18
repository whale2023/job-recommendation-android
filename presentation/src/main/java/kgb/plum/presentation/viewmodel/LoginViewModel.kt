package kgb.plum.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _isLogin = MutableLiveData(false)
    val isLogin : LiveData<Boolean> = _isLogin

    private val _id = MutableLiveData("")
    val id : LiveData<String> = _id

    fun setId(text : String){
        _id.value = text
    }

    private val _pw = MutableLiveData("")
    val pw : LiveData<String> = _pw

    fun setPw(text : String){
        _pw.value = text
    }
}