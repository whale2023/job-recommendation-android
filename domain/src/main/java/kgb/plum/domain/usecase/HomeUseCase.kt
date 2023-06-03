package kgb.plum.domain.usecase

import kgb.plum.domain.model.RecruitRankItem
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.HomeRepository
import kgb.plum.domain.repository.WishRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository, private val wishRepository: WishRepository){

    fun getPopularCompany() : List<RecruitRankItem> {
        return homeRepository.getPopularCompany()
    }

    fun getWishList() : List<WishItemData> {
        return wishRepository.getWishList()
    }
}