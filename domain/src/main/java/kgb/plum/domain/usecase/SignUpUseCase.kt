package kgb.plum.domain.usecase

import kgb.plum.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val signUpRepository: SignUpRepository) {
    fun checkEmailFormat(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")

        return emailRegex.matches(email)
    }

    fun requestCertificationNumber(email: String) {
        signUpRepository.requestCertificationNumber(email)
    }
}