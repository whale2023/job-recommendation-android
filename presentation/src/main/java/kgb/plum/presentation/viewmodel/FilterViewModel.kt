package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.presentation.model.TagType
import kgb.plum.presentation.ui.common.textField.CustomTextFieldController
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor() : ViewModel() {
  private val _filterList = mutableStateListOf<TagType>()
  val filterList: List<TagType> = _filterList

  private val _selectedFilterMap = mutableStateMapOf<String, Boolean>()
  val selectedFilterMap: Map<String, Boolean> = _selectedFilterMap

  val searchTextFieldController: CustomTextFieldController =
    CustomTextFieldController(::updateFilterList)

  private lateinit var _navController: NavHostController

  init {
    updateFilterList()
    _filterList.map {
      _selectedFilterMap[it.toString()] = false
    }
  }

  fun init(navController: NavHostController) {
    this._navController = navController
  }

  private fun updateFilterList() {
    _filterList.clear()
    _filterList.addAll(TagType.values().filter {
      it.toString().contains(searchTextFieldController.text)
    })
  }

  fun updateIsFilterSelect(value: String) {
    _selectedFilterMap[value] = !(_selectedFilterMap[value] ?: true)
  }

  fun navigatePop() {
    _navController.navigateUp()
  }
}