package kgb.plum.domain.repository

import kgb.plum.domain.model.EntityWrapper

interface SignUpRepository {
    fun requestCertificationNumber(email: String)
    fun requestCertification(number: String) : Boolean
    suspend fun signUp(email: String, pw: String, name: String, disabilityType: String, disabilityLevel: String, age: String, addressInfo: String, addressDetail: String) : EntityWrapper<Int>
}