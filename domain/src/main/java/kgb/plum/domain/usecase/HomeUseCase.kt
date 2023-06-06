package kgb.plum.domain.usecase

import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.HomeRepository
import kgb.plum.domain.repository.WishRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository, private val wishRepository: WishRepository){

    fun getPopularCompany() : List<RankItem> {
        return homeRepository.getPopularCompany()
    }

    fun getWishList() : List<WishItemData> {
        return wishRepository.getWishList()
    }

    suspend fun getRankItemList() : EntityWrapper<List<RankItem>> {
        return homeRepository.getRankItemList()
    }

    suspend fun  getUserInfo() : Int {
        return homeRepository.getUserInfo()
    }
}