package kgb.plum.presentation.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.state.LoginState
import kgb.plum.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    private val _id = MutableLiveData("")
    val id : LiveData<String> = _id

    private val _pw = MutableLiveData("")
    val pw : LiveData<String> = _pw

    fun setId(text : String){
        _id.value = text
    }

    fun setPw(text : String){
        _pw.value = text
    }

    fun login() : LoginState{
        return loginUseCase.login(_id.value ?: "", _pw.value ?: "")
    }
}