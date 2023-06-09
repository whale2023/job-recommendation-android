package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.CareerModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.model.UserInfoModel
import kgb.plum.domain.model.state.MyPageState
import kgb.plum.domain.usecase.MyPageUseCase
import kgb.plum.presentation.model.CareerMajorType
import kgb.plum.presentation.model.CertificationType
import kgb.plum.presentation.model.EducationType
import kgb.plum.presentation.model.MajorType
import kgb.plum.presentation.model.WorkType
import kgb.plum.presentation.ui.common.textField.CustomTextFieldController
import kgb.plum.presentation.ui.common.dialog.CustomDialogController
import kgb.plum.presentation.ui.common.dropdown.CustomDropdownMenuController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val myPageUseCase: MyPageUseCase) : ViewModel() {
  private val _resumeState: MutableStateFlow<MyPageState> = MutableStateFlow(MyPageState.Loading)
  val resumeState: StateFlow<MyPageState> = _resumeState

  fun resetResumeState() {
    _resumeState.value = MyPageState.Loading
  }

  init {
    viewModelScope.launch {
      setResume(myPageUseCase.getResume())
    }
  }

  private fun setResume(result: EntityWrapper<ResumeModel>) {
    when(result) {
      is EntityWrapper.Success -> {
        Log.d("??", "resume success ${result.entity}")
        _resumeState.value = MyPageState.Main(
          result.entity
        )
      }
      is EntityWrapper.Fail -> {
        Log.d("??", "resume error")
        MyPageState.Failed(
          reason = result.error.message ?: "Unknown error"
        )
      }
    }
  }

  val userInfoModel: UserInfoModel =
    UserInfoModel("박준식", 25, "qkrwnstlr@naver.com", "구미시", "청각 3급")

  val resumeDialogController = CustomDialogController()
  val resumeMajorDropdownMenuController = CustomDropdownMenuController(
    MajorType.ETC,
    MajorType.values().toList(),
  )
  val resumeEducationDropdownMenuController = CustomDropdownMenuController(
    EducationType.MIDDLE,
    EducationType.values().toList(),
  )
  val resumeWorkTypeDropdownMenuController = CustomDropdownMenuController(
    WorkType.ETC,
    WorkType.values().toList(),
  )
  val resumePreferIncomeTextFieldController = CustomTextFieldController()

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

  fun editResume(resumeModel: ResumeModel) {
    resumeDialogController.close()
    viewModelScope.launch {
      myPageUseCase.saveResume(
        resumeModel.copy(
          major = resumeMajorDropdownMenuController.currentValue.toString(),
          education = resumeMajorDropdownMenuController.currentValue.toString(),
          preferIncome = resumePreferIncomeTextFieldController.text.toLong(),
          workType = resumeWorkTypeDropdownMenuController.currentValue.toString()
        )
      )
    }
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

  fun addCertification(resumeModel: ResumeModel, value: CertificationType) {
    certificationDialogController.close()
    val newCertifications = resumeModel.certifications.toMutableList()
    newCertifications.add(value.toString())
    viewModelScope.launch {
      setResume(myPageUseCase.saveResume(resumeModel.copy(certifications = newCertifications)))
    }
  }

  fun removeCertification(resumeModel: ResumeModel, index: Int) {
    val newCertifications = resumeModel.certifications.toMutableList()
    newCertifications.removeAt(index)
    viewModelScope.launch {
      setResume(myPageUseCase.saveResume(resumeModel.copy(certifications = newCertifications)))
    }
  }

  fun addCareer(resumeModel: ResumeModel, careerModel: CareerModel) {
    careerDialogController.close()
    val newCareers = resumeModel.careerList.toMutableList()
    newCareers.add(careerModel)
    viewModelScope.launch {
      setResume(myPageUseCase.saveResume(resumeModel.copy(careerList = newCareers)))
    }
  }

  fun removeCareer(resumeModel: ResumeModel, index: Int) {
    val newCareers = resumeModel.careerList.toMutableList()
    newCareers.removeAt(index)
    viewModelScope.launch {
      setResume(myPageUseCase.saveResume(resumeModel.copy(careerList = newCareers)))
    }
  }
}