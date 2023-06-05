package kgb.plum.data.mapper

import kgb.plum.data.model.CompanyResponse
import kgb.plum.domain.model.RankItem

fun CompanyResponse.toRankItem(): RankItem = RankItem(
    company = this.companyName,
    occupation = this.recruitmentType
)