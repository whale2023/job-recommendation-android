package kgb.plum.data.datasource

import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.model.NetworkRequestInfo
import kgb.plum.data.library.model.RequestType
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.model.SignUpRequest
import kgb.plum.data.network.SignUpApi
import javax.inject.Inject

class SignUpDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : SignUpApi {
    override suspend fun signUp(
        username: String,
        age: Int,
        email: String,
        encryptedPwd: String,
        addressInfo: String,
        addressDetails: String,
        disabilityType: String
    ): ApiResult<SignUpRequest> {
        return networkRequestFactory.create(
            url = "members",
            type = object : TypeToken<SignUpRequest>(){}.type,
            requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withBody(
                requestBody =
                SignUpRequest(
                    username = username,
                    age = age,
                    email = email,
                    encryptedPwd = encryptedPwd,
                    addressInfo = addressInfo,
                    addressDetails = addressDetails,
                    disabilityType = disabilityType
            )).build()
        )
    }

}