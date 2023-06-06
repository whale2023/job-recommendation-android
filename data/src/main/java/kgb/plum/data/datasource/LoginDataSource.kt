package kgb.plum.data.datasource

import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.model.NetworkRequestInfo
import kgb.plum.data.library.model.RequestType
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.model.LoginRequest
import kgb.plum.data.model.LoginResponse
import kgb.plum.data.network.LoginApi
import javax.inject.Inject

class LoginDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : LoginApi {
    override suspend fun login(email: String, password: String): ApiResult<LoginResponse> {
        return networkRequestFactory.create(
            url = "members/login",
            type = object: TypeToken<LoginResponse>(){}.type,
            requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withBody(
                LoginRequest(email = email, password = password)
            ).build()
        )
    }

}