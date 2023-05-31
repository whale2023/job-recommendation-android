package kumoh.whale.whale.recruit

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import kumoh.whale.whale.model.entity.RecruitEntity
import kumoh.whale.whale.model.repository.RecruitRepository
import kumoh.whale.whale.ui.commons.CustomDropdownMenuController

class RecruitViewModel : ViewModel() {
  private val _recruitRepository = RecruitRepository
  val recruitList: SnapshotStateList<RecruitEntity>
    get() = _recruitRepository.recruitList

  val sortDropdownMenuController = CustomDropdownMenuController(
    SortType.NEWEST,
    SortType.values().toList(),
  )
}