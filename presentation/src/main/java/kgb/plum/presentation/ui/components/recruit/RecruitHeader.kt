package kgb.plum.presentation.ui.components.recruit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kgb.plum.presentation.model.SortType
import kgb.plum.presentation.ui.common.CustomDropdownMenuController
import kgb.plum.presentation.ui.common.CustomTextDropdownMenu
import kgb.plum.presentation.ui.theme.Padding

@Composable
fun RecruitHeader(
  totalCount: Int,
  sortDropdownMenuController: CustomDropdownMenuController<SortType>,
  filterDropdownMenuController: CustomDropdownMenuController<String>,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier = modifier
      .height(ButtonDefaults.MinHeight), verticalAlignment = Alignment.CenterVertically
  ) {
    Text(text = "전체 ${totalCount}개")
    Spacer(modifier = Modifier.weight(1f))
    CustomTextDropdownMenu(
      controller = filterDropdownMenuController,
      modifier = Modifier.wrapContentSize()
    )
    Spacer(modifier = Modifier.width(Padding.medium))
    CustomTextDropdownMenu(
      controller = sortDropdownMenuController,
      modifier = Modifier.wrapContentSize()
    )
  }
}

@Preview
@Composable
fun Preview() {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    RecruitHeader(
      0, CustomDropdownMenuController(
        SortType.NEWEST,
        SortType.values().toList(),
      ), CustomDropdownMenuController(
        "필터",
        listOf("필터")
      )
    )
  }
}