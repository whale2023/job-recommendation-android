package kgb.plum.data.repository

import kgb.plum.data.datasource.MyPageDataSource
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(private val myPageDataSource: MyPageDataSource) : MyPageRepository {
  override fun getResume(): ResumeModel {
    return myPageDataSource.getResume()
  }

  override fun saveResume(resumeModel: ResumeModel): ResumeModel {
    return myPageDataSource.saveResume(resumeModel)
  }
}