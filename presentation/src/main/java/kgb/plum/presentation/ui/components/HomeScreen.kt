package kgb.plum.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kgb.plum.presentation.R
import kgb.plum.presentation.ui.common.AsyncImageSlider
import kgb.plum.presentation.ui.common.RecruitCardItem
import kgb.plum.presentation.ui.common.WishItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.ui.theme.nameMedium
import kgb.plum.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.delay


val images = listOf(
    "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F9995B5425EA8EA761D",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6ksF7TTo_05EZphWWYu8ZRCwpAxp1IEjeqA&usqp=CAU",
    "https://cdn.goodnews1.com/news/photo/202104/111942_36930_342.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQakuxPhhhT8b0wilYwrS8W8GAqCv97t225ZA&usqp=CAU"
)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(){
    val viewModel = hiltViewModel<HomeViewModel>()
    val state = rememberPagerState()
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.
                    padding(Padding.extra)
                .verticalScroll(scrollState)
        ){
            Row(
                verticalAlignment = Alignment.Bottom
            ){
                Text(
                    text = "박준식",
                    style = MaterialTheme.typography.nameMedium
                )
                Text(
                    text = "님 안녕하세요?",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.size(12.dp))
            AutoSlidingCarousel(
                itemsCount = images.size,
                itemContent = { index ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(images[index])
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(200.dp)
                    )
                }
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "인기 채용 정보",
                style = MaterialTheme.typography.nameMedium
            )
            Spacer(modifier = Modifier.size(12.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Padding.large),
                contentPadding = PaddingValues(
                    start = Padding.small,
                    end = Padding.small
                )
            ){
                items(viewModel.popularCompany, key = {it.rank}) { item ->
                    RecruitCardItem(rank = item.rank, company = item.company, occupation = item.occupation)
                }
            }
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "관심을 표한 회사에요",
                style = MaterialTheme.typography.nameMedium
            )
            Spacer(modifier = Modifier.size(12.dp))
            Card(
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.surface),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        0.5.dp,
                        MaterialTheme.colors.textFiledBackgroundVariant,
                        MaterialTheme.shapes.medium
                    )
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(Padding.large)
                ) {
                    WishItem(MaterialTheme.colors.background,
                        if(viewModel.wishList.size>0) viewModel.wishList[0].company else null,
                        if(viewModel.wishList.size>0) viewModel.wishList[0].occupation else null,
                        if(viewModel.wishList.size>0) viewModel.wishList[0].dDay else null)
                    Spacer(modifier = Modifier.size(Padding.large))
                    WishItem(MaterialTheme.colors.secondary,
                        if(viewModel.wishList.size>1) viewModel.wishList[1].company else null,
                        if(viewModel.wishList.size>1) viewModel.wishList[1].occupation else null,
                        if(viewModel.wishList.size>1) viewModel.wishList[1].dDay else null)
                    Spacer(modifier = Modifier.size(Padding.large))
                    WishItem(MaterialTheme.colors.background,
                        if(viewModel.wishList.size>2) viewModel.wishList[2].company else null,
                        if(viewModel.wishList.size>2) viewModel.wishList[2].occupation else null,
                        if(viewModel.wishList.size>2) viewModel.wishList[2].dDay else null)
                }


            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSlidingCarousel(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = 2000,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(pagerState.currentPage) {
        delay(autoSlideDuration)
        pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
    }

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(count = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }

        // you can remove the surface in case you don't want
        // the transparant bacground
        Surface(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.5f)
        ) {
            DotsIndicator(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                totalDots = itemsCount,
                selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
                dotSize = 8.dp
            )
        }
    }
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = MaterialTheme.colors.primary,
    unSelectedColor: Color = MaterialTheme.colors.surface,
    dotSize: Dp
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}




@Preview
@Composable
fun HomeScreenPreview(){
    WhaleTheme {
        HomeScreen()
    }
}