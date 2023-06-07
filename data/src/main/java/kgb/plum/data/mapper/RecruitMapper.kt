package kgb.plum.data.mapper

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import javax.inject.Inject

class RecruitMapper @Inject constructor() : BaseMapper<List<CompanyModel>, List<CompanyModel>>() {
  override fun getSuccess(
    model: List<CompanyModel>?,
    extra: Any?
  ): EntityWrapper.Success<List<CompanyModel>> {
    return model?.let {
      EntityWrapper.Success(
        entity = model
      )
    } ?: EntityWrapper.Success(
      entity = listOf()
    )
  }

  override fun getFailure(error: Throwable): EntityWrapper.Fail<List<CompanyModel>> {
    return EntityWrapper.Fail(error)
  }
}