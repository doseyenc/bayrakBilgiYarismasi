package com.example.bayrakuygulamasi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bayrakuygulamasi.R;

public class sonucActivity extends AppCompatActivity {
private TextView textViewSonuc,textViewBasariYuzdesi;
private Button buttonTekrarOyna;
private int dogruSayisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        textViewSonuc=findViewById(R.id.textViewSonuc);
        textViewBasariYuzdesi=findViewById(R.id.textViewBasariYuzdesi);
        dogruSayisi=getIntent().getIntExtra("dogruSayac",0);
        textViewSonuc.setText(dogruSayisi+ " Doğru "+(5-dogruSayisi)+" Yanlış");
        textViewBasariYuzdesi.setText("%"+dogruSayisi*20+" Başarı");

        buttonTekrarOyna=findViewById(R.id.buttonTekrarOyna);

        buttonTekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sonucActivity.this,oyunActivity.class));
                finish();
            }
        });
    }
}