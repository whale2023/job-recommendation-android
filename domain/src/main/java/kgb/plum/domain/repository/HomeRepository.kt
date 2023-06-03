package kgb.plum.domain.repository

import kgb.plum.domain.model.RecruitRankItem
import kgb.plum.domain.model.WishItemData
import kotlinx.coroutines.flow.MutableStateFlow

interface HomeRepository {
    fun getPopularCompany() : List<RecruitRankItem>

}