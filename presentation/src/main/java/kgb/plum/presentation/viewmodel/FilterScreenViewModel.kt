package kgb.plum.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.presentation.model.TagType
import kgb.plum.presentation.ui.common.CustomTextFieldController
import javax.inject.Inject

@HiltViewModel
class FilterScreenViewModel @Inject constructor() : ViewModel() {
  private val _filterList = mutableStateListOf<TagType>()
  val filterList: List<TagType> = _filterList

  val searchTextFieldController: CustomTextFieldController =
    CustomTextFieldController(::updateFilterList)

  private lateinit var _navController: NavHostController

  fun init(navController: NavHostController) {
    this._navController = navController
    updateFilterList()
  }

  private fun updateFilterList() {
    _filterList.clear()
    val tempList =
      TagType.values().filter { it.toString().contains(searchTextFieldController.text) }
    tempList.forEach { _filterList.add(it) }
  }

  fun navigatePop() {
    _navController.popBackStack()
  }
}