package kgb.plum.data.mapper

import android.util.Log
import kgb.plum.data.library.model.ApiResult
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.ResumeModel
import javax.inject.Inject

class ResumeMapper @Inject constructor() : BaseMapper<ResumeModel, ResumeModel>() {
  override fun getSuccess(model: ResumeModel?, extra: Any?): EntityWrapper.Success<ResumeModel> {
    return model?.let {
      EntityWrapper.Success(
        entity = if(model.careers == null) model.copy(careers = listOf()) else model
      )
    } ?: EntityWrapper.Success(
      entity = ResumeModel("", "", 0, "", listOf(), listOf(), listOf(), "")
    )
  }

  override fun getFailure(error: Throwable): EntityWrapper.Fail<ResumeModel> {
    return EntityWrapper.Fail(error)
  }

  override fun mapFromResult(
    result: ApiResult<ResumeModel>,
    extra: Any?
  ): EntityWrapper<ResumeModel> = when (result.code) {
    400 -> getSuccess(model = null, extra)
    else -> super.mapFromResult(result, extra)
  }
}