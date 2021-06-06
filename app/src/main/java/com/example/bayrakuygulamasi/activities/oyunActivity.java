package com.example.bayrakuygulamasi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bayrakuygulamasi.Bayraklar;
import com.example.bayrakuygulamasi.BayraklarDao;
import com.example.bayrakuygulamasi.R;
import com.example.bayrakuygulamasi.Veritabani;

import java.util.ArrayList;
import java.util.HashSet;

public class oyunActivity extends AppCompatActivity {
private TextView textViewDogruSayisi,textViewYanlisSayisi,textViewSoruSayisi;
private ImageView imageViewBayrak;
private Button buttonSecenek1,buttonSecenek2,buttonSecenek3,buttonSecenek4;
private ArrayList<Bayraklar> flags;
private ArrayList<Bayraklar> wrongFlags;
private Bayraklar trueFlag;
private Veritabani vt;
//Counters
private int soruSayac=0;
private int yanlisSayac=0;
private int dogruSayac=0;
//Secenkler
private HashSet<Bayraklar> seceneklerHash=new HashSet<>();
private ArrayList<Bayraklar> secenklerList = new ArrayList<>();

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
        vt= new Veritabani(this);
        flags=new BayraklarDao().getRandomFiveFlag(vt);
        soruYukle();

        buttonSecenek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonSecenek1);
                checkCounter();
            }
        });
        buttonSecenek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonSecenek2);
                checkCounter();
            }
        });
        buttonSecenek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonSecenek3);
                checkCounter();
            }
        });
        buttonSecenek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonSecenek4);
                checkCounter();
            }
        });
    }
    public void soruYukle(){
        textViewSoruSayisi.setText((soruSayac+1)+". SORU");


        trueFlag=flags.get(soruSayac);
        wrongFlags=new BayraklarDao().getRandomWrongFlags(vt,trueFlag.getBayrak_id());
        imageViewBayrak.setImageResource(getResources().getIdentifier(trueFlag.getBayrak_resim(),"drawable",getPackageName()));
        seceneklerHash.clear();
        seceneklerHash.add(trueFlag);
        seceneklerHash.add(wrongFlags.get(0));
        seceneklerHash.add(wrongFlags.get(1));
        seceneklerHash.add(wrongFlags.get(2));
        for (Bayraklar b : seceneklerHash){
            secenklerList.add(b);
        }
        buttonSecenek1.setText(secenklerList.get(0).getBayrak_ad());
        buttonSecenek2.setText(secenklerList.get(1).getBayrak_ad());
        buttonSecenek3.setText(secenklerList.get(2).getBayrak_ad());
        buttonSecenek4.setText(secenklerList.get(3).getBayrak_ad());
        secenklerList.clear();

    }
    public void checkAnswer(Button clickedButton){
        String clickedAnswer = (String) clickedButton.getText();
        if (clickedAnswer.equals(trueFlag.getBayrak_ad())){
            dogruSayac++;
        }
        else {
            yanlisSayac++;
            Toast.makeText(getApplicationContext(),"Doğru cevap : "+trueFlag.getBayrak_ad(),Toast.LENGTH_LONG).show();
        }

        textViewDogruSayisi.setText("Doğru : "+dogruSayac);
        textViewYanlisSayisi.setText("Yanlış : "+yanlisSayac);
    }
    public void checkCounter(){
        soruSayac++;
        if (soruSayac != 5){
            soruYukle();
        }
        else {
            Intent intent = new Intent(oyunActivity.this,sonucActivity.class);
            intent.putExtra("dogruSayac",dogruSayac);
            startActivity(intent);
            finish();
        }
    }
}