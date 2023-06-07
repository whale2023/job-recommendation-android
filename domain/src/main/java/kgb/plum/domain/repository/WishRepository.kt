package kgb.plum.domain.repository

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.WishItemData

interface WishRepository {
    suspend fun getWishList() : EntityWrapper<List<CompanyModel>>
    suspend fun addWishItem(jobAnnouncementId: Int) : Int
    suspend fun deleteWishItem(jobAnnouncementId: Int) : Int
}