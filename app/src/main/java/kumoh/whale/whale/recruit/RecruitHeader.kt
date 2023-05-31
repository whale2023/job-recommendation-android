package kumoh.whale.whale.recruit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kumoh.whale.whale.ui.commons.CustomDropdownMenuController
import kumoh.whale.whale.ui.commons.CustomTextDropdownMenu

@Composable
fun RecruitHeader(
  totalCount: Int,
  sortDropdownMenuController: CustomDropdownMenuController<SortType>,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier = modifier
      .height(ButtonDefaults.MinHeight), verticalAlignment = Alignment.CenterVertically
  ) {
    Text(text = "전체 ${totalCount}개")
    Box(modifier = Modifier.weight(1f))
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
      )
    )
  }
}