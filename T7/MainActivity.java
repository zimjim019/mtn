package com.example411.termworlseven;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    EditText eDT_text;
    Button speakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eDT_text = findViewById(R.id.editTextID);
        speakBtn = findViewById(R.id.btn_speak);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });
        speakBtn.setOnClickListener(v -> {
            String text = eDT_text.getText().toString();
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        });
    }
}