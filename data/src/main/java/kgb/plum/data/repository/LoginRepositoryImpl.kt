package kgb.plum.data.repository

import kgb.plum.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor() : LoginRepository {
    override fun login(id: String, pw: String) {
        println("실행")
    }
}