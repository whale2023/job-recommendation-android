package kgb.plum.data.repository

import kgb.plum.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor() : SignUpRepository {
    override fun requestCertificationNumber(email: String) {
        println("인증 번호 요청")
        //TODO("인증번호 요청하기")
    }

    override fun requestCertification(number: String): Boolean {
        return true
        //TODO("인증 요청")
    }
}