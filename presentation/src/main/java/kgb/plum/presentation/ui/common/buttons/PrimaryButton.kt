package kgb.plum.presentation.ui.common.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kumoh.whale.whale.ui.theme.Padding
import kumoh.whale.whale.ui.theme.WhaleTheme
import kumoh.whale.whale.ui.theme.colors

@Composable
fun PrimaryButton(
    modifier : Modifier = Modifier,
    text: String = "",
    @StringRes id: Int? = null,
    state: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            disabledContainerColor = MaterialTheme.colors.background,
            disabledContentColor = MaterialTheme.colors.onBackground
        ),
        enabled = state
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = id?.let { stringResource(id = id) } ?: text,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(Padding.small)
            )
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    WhaleTheme {
        PrimaryButton(text = "로그인 하기") {}
    }
}