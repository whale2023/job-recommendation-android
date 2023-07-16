package kgb.plum.data.repository

import android.util.Log
import kgb.plum.data.mapper.ResumeMapper
import kgb.plum.data.network.MyPageApi
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.ResumeModel
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
    val result = myPageApi.saveResume(resumeModel)
    Log.d("MyPageRepositoryImpl.saveResume", result.code.toString())
    return resumeMapper.mapFromResult(
      result = result
    )
  }

  override suspend fun deleteResume(): EntityWrapper<ResumeModel> {
    return resumeMapper.mapFromResult(
      result = myPageApi.deleteResume()
    )
  }
}