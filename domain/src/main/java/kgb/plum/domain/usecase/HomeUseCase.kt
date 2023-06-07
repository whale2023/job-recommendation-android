package kgb.plum.domain.usecase

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.HomeRepository
import kgb.plum.domain.repository.WishRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository){


    suspend fun getRankItemList() : EntityWrapper<List<CompanyModel>> {
        return homeRepository.getRankItemList()
    }

    suspend fun  getUserInfo() : Int {
        return homeRepository.getUserInfo()
    }
}