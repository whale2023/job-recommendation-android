package kgb.plum.domain.repository

interface LoginRepository {

    fun login(id: String, pw: String)
}