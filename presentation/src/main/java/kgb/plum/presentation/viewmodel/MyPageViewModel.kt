package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.model.UserInfoModel
import kgb.plum.domain.usecase.MyPageUseCase
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val myPageUseCase: MyPageUseCase) : ViewModel() {
  val resumeModel: ResumeModel
    get() = myPageUseCase.getResume()
  val userInfoModel: UserInfoModel =
    UserInfoModel("박준식", 25, "qkrwnstlr@naver.com", "구미시", "청각 3급")

  fun editUserInfo() {
    Log.d("MyPageViewModel", "editUserInfo button is Clicked")
  }
}