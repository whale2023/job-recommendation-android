package kgb.plum.domain.usecase

import kgb.plum.domain.model.state.LoginState
import kgb.plum.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {

    fun login(id: String, pw: String) : LoginState {
        val state = checkLoginForm(id, pw)
        if(state  != LoginState.SUCCESS) return state
        loginRepository.login(id, pw)
        return LoginState.SUCCESS
    }

    private fun checkLoginForm(id: String, pw : String) : LoginState{
        if(id.isEmpty() || pw.isEmpty()) return LoginState.ID_PW_EMPTY
        else if(!isEmailValid(id)) return LoginState.NOT_EMAIL
        return LoginState.SUCCESS
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")

        return emailRegex.matches(email)
    }
}