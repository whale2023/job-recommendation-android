package kgb.plum.domain.repository

interface SignUpRepository {
    fun requestCertificationNumber(email: String)
    fun requestCertification(number: String) : Boolean
}