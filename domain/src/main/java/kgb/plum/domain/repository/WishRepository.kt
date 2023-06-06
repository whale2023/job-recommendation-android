package kgb.plum.domain.repository

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.WishItemData

interface WishRepository {
    fun getWishListItem() : List<WishItemData>
    suspend fun getWishList() : EntityWrapper<List<CompanyModel>>
}