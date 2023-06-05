package kgb.plum.data.repository

import kgb.plum.data.datasource.HomeDataSource
import kgb.plum.data.mapper.RankMapper
import kgb.plum.data.network.HomeApi
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource,
    private val homeApi: HomeApi,
    private val rankMapper: RankMapper
    ) : HomeRepository {
    override fun getPopularCompany(): List<RankItem> {
        return homeDataSource.getPopularCompany()
    }

    override suspend fun getRankItemList() : EntityWrapper<List<RankItem>> {
        return rankMapper.mapFromResult(
            result = homeApi.getRankItemList()
        )
    }


}