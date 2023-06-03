package kgb.plum.data.repository

import kgb.plum.data.datasource.RecommendDataSource
import kgb.plum.domain.model.RecommendItemData
import kgb.plum.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendRepositoryImpl @Inject constructor(private val recommendDataSource: RecommendDataSource) : RecommendRepository {
    override fun getRecommendList(): List<RecommendItemData> {
        return recommendDataSource.getRecommendList()
    }
}