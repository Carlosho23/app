package com.example.appseta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    ImageView imagem;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagem = findViewById(R.id.seta);
        texto = findViewById(R.id.texto_inicio);



    }
    public void clicouTela (View view){


        if (Math.random() < 0.5){
            texto.setText("Seiga para Esquerda");
            imagem.setScaleX(-1f);
        } else {
            texto.setText("Siga para Direita");
            imagem.setScaleX(1f);
        }
    }

}