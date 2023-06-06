package kgb.plum.domain.model.state

import kgb.plum.domain.model.RankItem

sealed class RankState {
    object Loading: RankState()
    class Main(
        val rankList: List<RankItem>
    ) : RankState()
    class Failed(
        val reason: String
    ): RankState()
}