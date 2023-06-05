package kgb.plum.domain.repository

import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem

interface HomeRepository {
    fun getPopularCompany() : List<RankItem>

    suspend fun getRankItemList() : EntityWrapper<List<RankItem>>

}