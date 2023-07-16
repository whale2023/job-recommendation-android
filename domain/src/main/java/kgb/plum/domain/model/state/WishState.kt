package kgb.plum.domain.model.state

import kgb.plum.domain.model.CompanyModel

sealed class WishState {
    object Loading: WishState()
    class Main(
        val wishList: MutableList<CompanyModel>
    ) : WishState()
    class Failed(
        val reason: String
    ): WishState()
}