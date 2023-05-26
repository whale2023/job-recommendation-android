package kgb.plum.presentation.bridge

import android.util.Log
import android.webkit.JavascriptInterface
import androidx.compose.runtime.MutableState
import kgb.plum.domain.model.AddressInfo

class AddressBridgeInterface(private val state: MutableState<Boolean>) {
    @JavascriptInterface
    fun processDATA(data: String) {
        Log.d("테스트", "되나?")
        Log.d("테스트" , data)
        AddressInfo.address = data
        state.value = false
    }
}