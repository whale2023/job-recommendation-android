package kgb.plum.presentation.ui.common.webview

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import kgb.plum.presentation.bridge.AddressBridgeInterface
import kgb.plum.presentation.ui.theme.Padding

@Composable
fun SearchAddressScreen(state: MutableState<Boolean>){
    AndroidView(factory = {
        WebView(it).apply{
            settings.javaScriptEnabled = true
            addJavascriptInterface(AddressBridgeInterface(state), "Android")
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    loadUrl("javascript:sample2_execDaumPostcode();")
                }
            }
            loadUrl("https://whale-7993e.web.app/")
        }
    },
        modifier = Modifier.fillMaxSize().padding(Padding.medium)
    )
}