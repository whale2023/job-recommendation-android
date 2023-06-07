package kgb.plum.data.repository

import kgb.plum.data.library.model.ApiResponse
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.mapper.CompanyMapper
import kgb.plum.data.network.HomeApi
import kgb.plum.data.network.UserApi
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.UserInfo
import kgb.plum.domain.model.UserInfoModel
import kgb.plum.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi,
    private val userApi: UserApi,
    private val companyMapper: CompanyMapper
    ) : HomeRepository {


    override suspend fun getRankItemList() : EntityWrapper<List<CompanyModel>> {
        return companyMapper.mapFromResult(
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