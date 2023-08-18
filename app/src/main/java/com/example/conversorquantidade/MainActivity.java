package com.example.conversorquantidade;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conversorquantidade.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String fullText = "Texto para animação progressiva...";
    private int charIndex = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        animateText();
    }

    private void animateText() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (charIndex <= fullText.length()) {
                    textView.setText(fullText.substring(0, charIndex));
                    charIndex++;
                    handler.postDelayed(this, 100); // Intervalo de exibição de caractere (ajuste conforme necessário)
                }
            }
        }, 100); // Atraso inicial
    }
}