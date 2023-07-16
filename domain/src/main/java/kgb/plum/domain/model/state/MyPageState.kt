package kgb.plum.domain.model.state

import kgb.plum.domain.model.ResumeModel

sealed class MyPageState {
  object Loading: MyPageState()
  class Main(
    var resumeModel: ResumeModel
  ) : MyPageState()
  class Failed(
    val reason: String
  ): MyPageState()
}
