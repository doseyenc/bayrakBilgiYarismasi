package com.example.bayrakuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class oyunActivity extends AppCompatActivity {
private TextView textViewDogruSayisi,textViewYanlisSayisi,textViewSoruSayisi;
private ImageView imageViewBayrak;
private Button buttonSecenek1,buttonSecenek2,buttonSecenek3,buttonSecenek4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);

        textViewDogruSayisi=findViewById(R.id.textViewDogruSayisi);
        textViewSoruSayisi=findViewById(R.id.textViewSoruSayisi);
        textViewYanlisSayisi=findViewById(R.id.textViewYanlisSayisi);

        imageViewBayrak=findViewById(R.id.imageViewBayrak);
        imageViewBayrak.setImageResource(R.drawable.almanya);

        buttonSecenek1=findViewById(R.id.buttonSecenek1);
        buttonSecenek2=findViewById(R.id.buttonSecenek2);
        buttonSecenek3=findViewById(R.id.buttonSecenek3);
        buttonSecenek4=findViewById(R.id.buttonSecenek4);
        Intent intent = new Intent(oyunActivity.this,sonucActivity.class);
        buttonSecenek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
        buttonSecenek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
        buttonSecenek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
        buttonSecenek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
    }
}