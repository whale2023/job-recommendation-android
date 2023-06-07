package kgb.plum.domain.usecase

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RecommendItemData
import kgb.plum.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendUseCase @Inject constructor(private val recommendRepository: RecommendRepository){
    fun getRecommendList() : List<RecommendItemData> {
        return recommendRepository.getRecommendList()
    }
    suspend fun getWishListBaseRecommend(id: String) : EntityWrapper<List<CompanyModel>>{
        return recommendRepository.getWishListBaseRecommend(id)
    }
}