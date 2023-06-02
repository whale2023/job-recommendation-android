package kgb.plum.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors

@Composable
fun WishItem(
    color: Color,
    company: String?= null,
    occupation: String? = null,
    dDay: String?= null
){
    Row(
        modifier = Modifier
            .background(color, shape = MaterialTheme.shapes.large)
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = Padding.extra),
        verticalAlignment = Alignment.CenterVertically
    ){
        if(company.isNullOrEmpty()){
            Text(
                text = "위시리스트를 추가해보세요.",
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            Column(){
                Text(
                    text = company,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = occupation ?: "",
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = dDay ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun WishItemPreview() {
    WhaleTheme {
        WishItem(color = MaterialTheme.colors.background, "금오컴퍼니", "영업직", "D-7")
    }
}