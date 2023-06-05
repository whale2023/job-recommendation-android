package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.model.SignUpRequest

interface SignUpApi {
    suspend fun signUp(username: String, age: Int, email:String, encryptedPwd: String, addressInfo: String, addressDetails: String, disabilityType: String) : ApiResult<SignUpRequest>
}