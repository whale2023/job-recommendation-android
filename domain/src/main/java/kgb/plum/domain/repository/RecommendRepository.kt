package kgb.plum.domain.repository

import kgb.plum.domain.model.RecommendItemData

interface RecommendRepository {
    fun getRecommendList() : List<RecommendItemData>
}