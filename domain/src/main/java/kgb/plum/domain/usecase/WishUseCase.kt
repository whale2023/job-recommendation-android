package kgb.plum.domain.usecase

import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.WishRepository
import javax.inject.Inject

class WishUseCase @Inject constructor(private val wishRepository: WishRepository) {
    fun getWishList() : List<WishItemData>{
        return wishRepository.getWishList()
    }
}