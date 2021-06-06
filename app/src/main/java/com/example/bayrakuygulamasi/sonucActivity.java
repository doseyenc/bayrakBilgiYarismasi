package com.example.bayrakuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sonucActivity extends AppCompatActivity {
private TextView textViewSonuc,textViewBasariYuzdesi;
private Button buttonTekrarOyna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        textViewSonuc=findViewById(R.id.textViewSonuc);
        textViewBasariYuzdesi=findViewById(R.id.textViewBasariYuzdesi);

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