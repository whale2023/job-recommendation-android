package kumoh.whale.whale.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kumoh.whale.whale.R
import kumoh.whale.whale.ui.theme.WhaleTheme
import kumoh.whale.whale.ui.theme.mainBlue

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhaleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(){
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Spacer(
                modifier = Modifier.fillMaxHeight(0.2f)
            )
            Image(
                modifier = Modifier.fillMaxSize(0.2f),
                painter = painterResource(id = R.drawable.baseline_cloud_72),
                contentDescription = "로고 예시"
            )
            Text(text = "로고 예시")
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = mainBlue)
            ) {
                Text(text = stringResource(id = R.string.sign_in_with_email))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.03f))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = mainBlue)
            ){
                Text(text = stringResource(id = R.string.sign_up))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    WhaleTheme {
        LoginScreen()
    }
}