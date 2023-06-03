package kgb.plum.domain.usecase

import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageUseCase @Inject constructor(private val myPageRepository: MyPageRepository) {
  fun getResume(): ResumeModel {
    return myPageRepository.getResume()
  }

  fun saveResume(resumeModel: ResumeModel): ResumeModel {
    return myPageRepository.saveResume(resumeModel)
  }
}