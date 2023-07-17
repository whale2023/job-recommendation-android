package kgb.plum.data.repository

import android.util.Log
import kgb.plum.data.library.model.ApiResponse
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
    val result = myPageApi.getResume()
    if(result.response is ApiResponse.Success)
      Log.d("MyPageRepositoryImpl", "getResume : ${result.response.data}")
    else if(result.response is ApiResponse.Fail)
      Log.d("MyPageRepositoryImpl", "getResume : ${result.response.error.message}")
    return resumeMapper.mapFromResult(
      result = result
    )
  }

  override suspend fun saveResume(resumeModel: ResumeModel): EntityWrapper<ResumeModel> {
    val result = myPageApi.saveResume(resumeModel)
    if(result.response is ApiResponse.Success)
      Log.d("MyPageRepositoryImpl", "saveResume : ${result.response.data}")
    else if(result.response is ApiResponse.Fail)
      Log.d("MyPageRepositoryImpl", "saveResume : ${result.response.error.message}")
    return resumeMapper.mapFromResult(
      result = result
    )
  }

  override suspend fun deleteResume(): EntityWrapper<ResumeModel> {
    val result = myPageApi.deleteResume()
    if(result.response is ApiResponse.Success)
      Log.d("MyPageRepositoryImpl", "deleteResume : ${result.response.data}")
    else if(result.response is ApiResponse.Fail)
      Log.d("MyPageRepositoryImpl", "deleteResume : ${result.response.error.message}")
    return resumeMapper.mapFromResult(
      result = result
    )
  }
}