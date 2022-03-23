package com.example.appseta;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {
    //seta propriedades
    ImageView imagem;
    TextView texto;
    Animation some;
    Animation aparece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagem = findViewById(R.id.seta);
        texto = findViewById(R.id.texto_inicio);
        //Tela quando inicia seta o texto e
        texto.setText("Toque para Continuar!");
        imagem.setVisibility(View.INVISIBLE);

        //Variaveis da animação
        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);

        //Duração da animação
        some.setDuration(500);
        aparece.setDuration(500);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //seta a imagem para visualizar no inicio da animação
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //seta a imagem para visualização final a animação
                imagem.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //seta a imagem para visualização no inicio da animação
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //seta a imagem para ficar invisivel no fim da animação
                imagem.setVisibility(View.INVISIBLE);
                //seta o texto para como no começo da aplicação
                texto.setText("Toque para Continuar!");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    //funcao de quando clicar na tela
    public void clicouTela(View view) {
        //if gerando aleatoriamente se for menor que 0.5 seta o texto para esquerda e a seta para o lado da esquerda
        if (Math.random() < 0.5) {
            texto.setText("Siga para Esquerda");
            imagem.setScaleX(-1f);
        //se não ele seta o texto para direita e a seta para direita
        } else {
            texto.setText("Siga para Direita");
            imagem.setScaleX(1f);
        }

        imagem.startAnimation(aparece);
        //Timer para a duração que vai ficar a seta
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imagem.startAnimation(some);
                    }
                });
            }
        },2000);
    }

}