package kgb.plum.domain.repository

interface SignUpRepository {
    fun requestCertificationNumber(email: String)
    fun requestCertification(number: String) : Boolean
    fun signUp(email: String, pw: String, name: String, disabilityType: String, disabilityLevel: String, age: String, addressInfo: String, addressDetail: String) : Int
}