package kgb.plum.data.datasource

import android.util.Log
import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.model.NetworkRequestInfo
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.network.UserApi
import kgb.plum.domain.LoginTokenData
import kgb.plum.domain.model.UserInfoModel
import javax.inject.Inject

class UserDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : UserApi {
    override suspend fun getUserInfo(): ApiResult<UserInfoModel> {
        return networkRequestFactory.create(
            url = "members",
            type = object : TypeToken<UserInfoModel>(){}.type,
            requestInfo = NetworkRequestInfo.Builder().withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
        )
    }
}