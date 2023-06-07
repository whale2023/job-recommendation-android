package kgb.plum.data.datasource

import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.model.NetworkRequestInfo
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.model.CompanyResponse
import kgb.plum.data.network.HomeApi
import kgb.plum.domain.LoginTokenData
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.WishItemData
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : HomeApi {

    override suspend fun getRankItemList(): ApiResult<List<CompanyResponse>> {
        return networkRequestFactory.create(
            url = "announcement/sort/wish?page=0&size=10&sort=id,asc",
            type = object : TypeToken<List<CompanyResponse>>(){}.type,
            requestInfo = NetworkRequestInfo.Builder().withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
        )
    }
}