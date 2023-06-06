package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.domain.model.UserInfoModel

interface UserApi {
    suspend fun getUserInfo() : ApiResult<UserInfoModel>
}