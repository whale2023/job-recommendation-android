package kgb.plum.data.repository

import kgb.plum.data.datasource.HomeDataSource
import kgb.plum.domain.model.RecruitRankItem
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeDataSource: HomeDataSource) : HomeRepository {
    override fun getPopularCompany(): List<RecruitRankItem> {
        return homeDataSource.getPopularCompany()
    }

    override fun getWishList(): List<WishItemData> {
        return homeDataSource.getWishList()
    }

}