package kgb.plum.domain.usecase

import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageUseCase @Inject constructor(private val myPageRepository: MyPageRepository) {
  suspend fun getResume(): EntityWrapper<ResumeModel> {
    return myPageRepository.getResume()
  }

  suspend fun saveResume(resumeModel: ResumeModel): EntityWrapper<ResumeModel> {
    return myPageRepository.saveResume(resumeModel)
  }
}