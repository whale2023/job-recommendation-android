package kgb.plum.domain.usecase


import kgb.plum.domain.LoginTokenData
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.LoginToken
import kgb.plum.domain.model.state.LoginState
import kgb.plum.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {

    suspend fun login(id: String, pw: String) : LoginState {
        val state = checkLoginForm(id, pw)
        if(state  != LoginState.SUCCESS) return state
        return when(val result = loginRepository.login(id, pw)) {
            is EntityWrapper.Success -> {
                when(result.entity.code) {
                    200 -> {
                        LoginTokenData.atk = result.entity.atk
                        LoginTokenData.rtk = result.entity.atk
                        LoginState.SUCCESS
                    }
                    404 -> {
                        LoginState.WRONG_PW_ID
                    }
                    else-> {
                        LoginState.UNKNOWN_ERROR
                    }
                }
            }
            is EntityWrapper.Fail -> {
                LoginState.UNKNOWN_ERROR
            }
        }
    }

    private fun checkLoginForm(id: String, pw : String) : LoginState {
        if(id.isEmpty() || pw.isEmpty()) return LoginState.ID_PW_EMPTY
        else if(!isEmailValid(id)) return LoginState.NOT_EMAIL
        return LoginState.SUCCESS
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")

        return emailRegex.matches(email)
    }
}