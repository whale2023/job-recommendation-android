package kgb.plum.domain.model.state

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.RankItem

sealed class RankState {
    object Loading: RankState()
    class Main(
        val rankList: List<CompanyModel>
    ) : RankState()
    class Failed(
        val reason: String
    ): RankState()
}