package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.CareerModel
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.model.UserInfoModel
import kgb.plum.domain.usecase.MyPageUseCase
import kgb.plum.presentation.model.CareerMajorType
import kgb.plum.presentation.model.careerMiddleType.CareerMiddleType
import kgb.plum.presentation.model.CertificationType
import kgb.plum.presentation.ui.common.textField.CustomTextFieldController
import kgb.plum.presentation.ui.common.dialog.CustomDialogController
import kgb.plum.presentation.ui.common.dropdown.CustomDropdownMenuController
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val myPageUseCase: MyPageUseCase) : ViewModel() {
  val resumeModel: ResumeModel
    get() = myPageUseCase.getResume()
  val userInfoModel: UserInfoModel =
    UserInfoModel("박준식", 25, "qkrwnstlr@naver.com", "구미시", "청각 3급")

  val careerDialogController = CustomDialogController()
  val careerMajorDropdownMenuController = CustomDropdownMenuController(
    CareerMajorType.BUSINESS_ADMINISTRATION_CLERICAL,
    CareerMajorType.values().toList(),
  )
  val yearDropdownMenuController = CustomDropdownMenuController(
    1,
    listOf(1, 2, 3, 4, 5),
  )

  val certificationDialogController = CustomDialogController()
  val certificationTextFieldController = CustomTextFieldController(::updateCertificationList)
  private val _certificationList = mutableStateListOf<CertificationType>()
  val certificationList: List<CertificationType> = _certificationList

  fun editUserInfo() {

  }

  fun initCertificationList() {
    _certificationList.clear()
    certificationTextFieldController.clearText()
    _certificationList.addAll(CertificationType.values())
  }

  private fun updateCertificationList() {
    _certificationList.clear()
    _certificationList.addAll(CertificationType.values().filter {
      it.toString().contains(certificationTextFieldController.text)
    })
  }

  fun addCertification(value: CertificationType) {
    certificationDialogController.close()
    val newCertifications = resumeModel.certifications.toMutableList()
    newCertifications.add(value.toString())
    myPageUseCase.saveResume(resumeModel.copy(certifications = newCertifications))
  }

  fun removeCertification(index: Int) {
    val newCertifications = resumeModel.certifications.toMutableList()
    newCertifications.removeAt(index)
    myPageUseCase.saveResume(resumeModel.copy(certifications = newCertifications))
  }

  fun addCareer(careerModel: CareerModel) {
    careerDialogController.close()
    val newCareers = resumeModel.careers.toMutableList()
    newCareers.add(careerModel)
    myPageUseCase.saveResume(resumeModel.copy(careers = newCareers))
    Log.d("MyPageViewModel", careerModel.category)
  }

  fun removeCareer(index: Int) {
    val newCareers = resumeModel.careers.toMutableList()
    newCareers.removeAt(index)
    myPageUseCase.saveResume(resumeModel.copy(careers = newCareers))
  }
}