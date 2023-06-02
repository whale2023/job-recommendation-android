package kgb.plum.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.RecruitModel
import kgb.plum.domain.usecase.RecruitUseCase
import kgb.plum.presentation.model.SortType
import kgb.plum.presentation.ui.common.CustomDropdownMenuController
import javax.inject.Inject

@HiltViewModel
class RecruitViewModel @Inject constructor(private val recruitUseCase: RecruitUseCase) :
  ViewModel() {
  val recruitList: List<RecruitModel>
    get() = recruitUseCase.getRecruitList()

  val sortDropdownMenuController = CustomDropdownMenuController(
    SortType.NEWEST,
    SortType.values().toList(),
  )
}
