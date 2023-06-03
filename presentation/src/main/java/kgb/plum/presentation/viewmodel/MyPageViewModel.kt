package kgb.plum.presentation.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.usecase.MyPageUseCase
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val myPageUseCase: MyPageUseCase) {
  val resumeModel: ResumeModel
    get() = myPageUseCase.getResume()
}