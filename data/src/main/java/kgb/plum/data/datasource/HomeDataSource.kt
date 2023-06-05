package kgb.plum.data.datasource

import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.model.CompanyResponse
import kgb.plum.data.network.HomeApi
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.WishItemData
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : HomeApi {
    val recruitRankItems = emptyList<RankItem>()

    fun getPopularCompany() : List<RankItem>{
        return recruitRankItems
    }

    fun getWishList() : List<WishItemData> {
        return emptyList()
    }

    override suspend fun getRankItemList(): ApiResult<List<CompanyResponse>> {
        return networkRequestFactory.create(
            url = "top250.json",
            type = object : TypeToken<List<CompanyResponse>>(){}.type
        )
    }
}