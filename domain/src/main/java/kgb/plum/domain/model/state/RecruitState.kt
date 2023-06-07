package kgb.plum.domain.model.state

import kgb.plum.domain.model.CompanyModel

sealed class RecruitState {
  object Loading: RecruitState()
  class Main(
    val recruitList: List<CompanyModel>
  ) : RecruitState()
  class Failed(
    val reason: String
  ): RecruitState()
}