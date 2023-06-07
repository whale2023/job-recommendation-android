package kgb.plum.data.repository

import android.util.Log
import kgb.plum.data.datasource.HomeDataSource
import kgb.plum.data.library.model.ApiResponse
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.mapper.RankMapper
import kgb.plum.data.mapper.WishMapper
import kgb.plum.data.network.HomeApi
import kgb.plum.data.network.UserApi
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.UserInfo
import kgb.plum.domain.model.UserInfoModel
import kgb.plum.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi,
    private val userApi: UserApi,
    private val wishMapper: WishMapper
    ) : HomeRepository {


    override suspend fun getRankItemList() : EntityWrapper<List<CompanyModel>> {
        return wishMapper.mapFromResult(
            result = homeApi.getRankItemList()
        )
    }

    override suspend fun getUserInfo() : Int {
        return userMapping(userApi.getUserInfo())
    }

    fun userMapping(result: ApiResult<UserInfoModel>) : Int {
        return when(result.response) {
            is ApiResponse.Success -> {
                UserInfo.userData = result.response.data
                200
            }
            is ApiResponse.Fail -> {
                400
            }
        }
    }


}