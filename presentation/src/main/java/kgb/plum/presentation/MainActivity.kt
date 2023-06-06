package kgb.plum.presentation

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import dagger.hilt.android.AndroidEntryPoint
import kgb.plum.presentation.ui.components.RootScreen
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.util.SpeechTool
import kgb.plum.presentation.util.SpeechTool.isSupported
import kgb.plum.presentation.util.SpeechTool.mRecognizer
import kgb.plum.presentation.util.SpeechTool.speakOut
import kgb.plum.presentation.util.SpeechTool.speechIntent
import kgb.plum.presentation.util.SpeechTool.tts
import java.util.Locale


@AndroidEntryPoint
class MainActivity : ComponentActivity(), TextToSpeech.OnInitListener{



    private var mBackWait:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this, arrayOf<String>(
                Manifest.permission.RECORD_AUDIO
            ), 1000)
        tts = TextToSpeech(this, this)
        val getSharedPreferences = getSharedPreferences("SpeechTool", Context.MODE_PRIVATE)
        isSupported = getSharedPreferences.getBoolean("isSupported", true)
        setContent {
            WhaleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootScreen(this)
                }
            }
        }
    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - mBackWait >=2000 ) {
            mBackWait = System.currentTimeMillis()
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_LONG).show()
        } else {
            finish()
        }
    }


    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        if(mRecognizer!=null){
            mRecognizer!!.destroy();
            mRecognizer!!.cancel();
            mRecognizer=null;
        }
        super.onDestroy()
    }

    override fun onInit(status: Int) {
        speechIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechIntent!!.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName())
        speechIntent!!.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR")
        if (status == TextToSpeech.SUCCESS)  {
            val result = tts?.setLanguage(Locale.KOREA);

            if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {

            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }


}

