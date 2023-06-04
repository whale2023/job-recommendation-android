package kgb.plum.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.presentation.ui.common.CustomTextFieldController
import javax.inject.Inject

@HiltViewModel
class EditListScreenViewModel @Inject constructor() : ViewModel() {
  val customTextFieldController = CustomTextFieldController()
  val list = mutableListOf<String>()
  fun init(list: List<String>) {
    list.forEach {
      this.list.add(it)
    }
  }
  fun addListItem(value: String) {

  }
}