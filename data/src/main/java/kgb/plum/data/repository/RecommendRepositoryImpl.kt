package kgb.plum.data.repository

import kgb.plum.data.datasource.RecommendDataSource
import kgb.plum.data.mapper.CompanyMapper
import kgb.plum.data.network.RecommendApi
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RecommendItemData
import kgb.plum.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendRepositoryImpl @Inject constructor(
    private val recommendDataSource: RecommendDataSource,
    private val recommendApi: RecommendApi,
    private val companyMapper: CompanyMapper
    ) : RecommendRepository {
    override fun getRecommendList(): List<RecommendItemData> {
        return recommendDataSource.getRecommendList()
    }

    override suspend fun getWishListBaseRecommend(id: String): EntityWrapper<List<CompanyModel>> {
        return companyMapper.mapFromResult(
            result = recommendApi.getWishListBasedRecommendList(id)
        )
    }

}