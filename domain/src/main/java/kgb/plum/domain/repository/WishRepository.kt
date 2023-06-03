package kgb.plum.domain.repository

import kgb.plum.domain.model.WishItemData

interface WishRepository {
    fun getWishList() : List<WishItemData>
}