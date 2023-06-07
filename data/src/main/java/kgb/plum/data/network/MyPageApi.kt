package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.domain.model.ResumeModel

interface MyPageApi {
  suspend fun getResume(): ApiResult<ResumeModel>
  suspend fun saveResume(resumeModel: ResumeModel): ApiResult<ResumeModel>
}