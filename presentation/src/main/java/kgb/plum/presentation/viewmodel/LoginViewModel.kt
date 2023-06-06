package kgb.plum.presentation.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.LoginTokenData
import kgb.plum.domain.model.state.LoginState
import kgb.plum.domain.usecase.LoginUseCase
import kgb.plum.presentation.model.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    private val _loginState: MutableStateFlow<LoginState> =
        MutableStateFlow(LoginState.LOADING)
    val loginState : StateFlow<LoginState> = _loginState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        LoginState.LOADING
    )

    var isSuccess = false

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

    fun login(){
        viewModelScope.launch {
            _loginState.value = LoginState.LOADING
            _loginState.value = loginUseCase.login(_id.value ?: "", _pw.value ?: "")
            if(_loginState.value == LoginState.SUCCESS) isSuccess = true
        }
    }

    fun saveToken(context: Context) {
        viewModelScope.launch {
            val sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("atk", LoginTokenData.atk)
            editor.putString("rtk", LoginTokenData.rtk)
            editor.apply()
        }
    }

    fun resetLoginState() {
        _loginState.value = LoginState.LOADING
    }
}