package kgb.plum.domain.model.state

import kgb.plum.domain.model.CompanyModel

sealed class WishRecommendState {
    object Loading: WishRecommendState()
    class Main(
        val companyList : List<CompanyModel>
    ) : WishRecommendState()
    class Failed(
        val reason : String
    ) : WishRecommendState()
}