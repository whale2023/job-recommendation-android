package kgb.plum.data.datasource

import kgb.plum.data.model.CompanyResponse
import kgb.plum.domain.model.WishItemData
import javax.inject.Inject

class WishDataSource @Inject constructor() {



  fun getWishList(): List<CompanyResponse> {
    return emptyList()
  }
}