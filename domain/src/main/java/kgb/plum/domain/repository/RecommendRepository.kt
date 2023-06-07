package kgb.plum.domain.repository

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RecommendItemData

interface RecommendRepository {
    fun getRecommendList() : List<RecommendItemData>

    suspend fun getWishListBaseRecommend(id: String) : EntityWrapper<List<CompanyModel>>
}