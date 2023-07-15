package kgb.plum.presentation.util

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

@Composable
fun LazyListState.isAtBottom(): Boolean {

  return remember(this) {
    derivedStateOf {
      val visibleItemsInfo = layoutInfo.visibleItemsInfo

      if (layoutInfo.totalItemsCount == 0) {
        false
      } else {
        val lastVisibleItem = visibleItemsInfo.last()
        val viewportHeight = layoutInfo.viewportEndOffset + layoutInfo.viewportStartOffset

        (lastVisibleItem.index + 1 == layoutInfo.totalItemsCount &&
            lastVisibleItem.offset + lastVisibleItem.size <= viewportHeight)
      }
    }
  }.value
}

@Composable
fun LazyListState.isAtTop(): Boolean {

  return remember(this) {
    derivedStateOf {
      val visibleItemsInfo = layoutInfo.visibleItemsInfo

      if (layoutInfo.totalItemsCount == 0) {
        false
      } else {
        val firstVisibleItem = visibleItemsInfo.first()
        val viewportHeight = layoutInfo.viewportEndOffset + layoutInfo.viewportStartOffset

        (firstVisibleItem.index == 0 &&
            firstVisibleItem.offset + firstVisibleItem.size <= viewportHeight)
      }
    }
  }.value
}