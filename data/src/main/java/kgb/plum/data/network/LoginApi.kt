package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.model.LoginResponse
import kgb.plum.domain.model.EntityWrapper

interface LoginApi {
    suspend fun login(email: String, password: String) : ApiResult<LoginResponse>
}