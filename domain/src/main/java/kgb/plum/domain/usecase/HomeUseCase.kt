package kgb.plum.domain.usecase

import kgb.plum.domain.model.RecruitRankItem
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository){

    fun getPopularCompany() : List<RecruitRankItem> {
        return homeRepository.getPopularCompany()
    }

    fun getWishList() : List<WishItemData> {
        return homeRepository.getWishList()
    }
}