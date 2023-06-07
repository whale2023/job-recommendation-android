package kgb.plum.data.repository

import kgb.plum.data.datasource.MyPageDataSource
import kgb.plum.data.library.model.ApiResponse
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.mapper.ResumeMapper
import kgb.plum.data.network.MyPageApi
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.model.UserInfo
import kgb.plum.domain.model.UserInfoModel
import kgb.plum.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(
  private val myPageApi: MyPageApi,
  private val resumeMapper: ResumeMapper
) : MyPageRepository {
  override suspend fun getResume(): EntityWrapper<ResumeModel> {
    return resumeMapper.mapFromResult(
      result = myPageApi.getResume()
    )
  }

  override suspend fun saveResume(resumeModel: ResumeModel): EntityWrapper<ResumeModel> {
    return resumeMapper.mapFromResult(
      result = myPageApi.saveResume(resumeModel)
    )
  }
}