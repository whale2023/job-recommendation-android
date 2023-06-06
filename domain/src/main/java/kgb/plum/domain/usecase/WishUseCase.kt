package kgb.plum.domain.usecase

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.WishRepository
import javax.inject.Inject

class WishUseCase @Inject constructor(private val wishRepository: WishRepository) {
    fun getWishListItem() : List<WishItemData>{
        return wishRepository.getWishListItem()
    }

    suspend fun getWishList(): EntityWrapper<List<CompanyModel>> {
        return wishRepository.getWishList()
    }
}