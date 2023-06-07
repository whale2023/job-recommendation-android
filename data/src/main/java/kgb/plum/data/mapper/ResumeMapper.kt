package kgb.plum.data.mapper

import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.ResumeModel
import javax.inject.Inject

class ResumeMapper @Inject constructor() :BaseMapper<ResumeModel, ResumeModel>() {
  override fun getSuccess(model: ResumeModel?, extra: Any?): EntityWrapper.Success<ResumeModel> {
    return model?.let {
      EntityWrapper.Success(
        entity = model
      )
    } ?: EntityWrapper.Success(
      entity = ResumeModel("", "", 0, "", listOf(), listOf())
    )
  }

  override fun getFailure(error: Throwable): EntityWrapper.Fail<ResumeModel> {
    return EntityWrapper.Fail(error)
  }
}