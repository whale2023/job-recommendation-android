package kgb.plum.domain.repository

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.UserInfoModel

interface HomeRepository {
    suspend fun getRankItemList() : EntityWrapper<List<CompanyModel>>
    suspend fun getUserInfo() : Int

}