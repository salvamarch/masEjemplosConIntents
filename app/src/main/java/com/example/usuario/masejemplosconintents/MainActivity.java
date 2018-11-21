package com.example.usuario.masejemplosconintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button compartirWhatsapp, compartirFACE, mapa,web;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.editText);
        compartirWhatsapp = findViewById(R.id.button);
        compartirFACE = findViewById(R.id.button2);
        mapa=findViewById(R.id.button3);
        web = findViewById(R.id.button4);

        compartirWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWhatsapp = new Intent(Intent.ACTION_SEND);
                intentWhatsapp.setType("text/plain");
                intentWhatsapp.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
                intentWhatsapp.setPackage("com.whatsapp");

                Intent aux = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (aux!=null) {
                    startActivity(intentWhatsapp);
                }else{
                    Toast.makeText(MainActivity.this, "Debes instalar WhatSAPP", Toast.LENGTH_SHORT).show();
                }


            }
        });
        compartirFACE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWhatsapp = new Intent(Intent.ACTION_SEND);
                intentWhatsapp.setType("text/plain");
                intentWhatsapp.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
                intentWhatsapp.setPackage("com.facebook.katana");

                Intent aux = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                if (aux!=null) {
                    startActivity(intentWhatsapp);
                }else{
                    Toast.makeText(MainActivity.this, "Debes instalar WhatSAPP", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coordenadas = "geo:38.2983421,-5.2736782";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(coordenadas));
                Intent seleccionador = Intent.createChooser(intent,"Elige tu programa favorito");
                startActivity(seleccionador);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(texto.getText().toString()));
                Intent seleccionador = Intent.createChooser(intent,"Elige tu navegador");
                startActivity(seleccionador);
            }
        });


    }
}
