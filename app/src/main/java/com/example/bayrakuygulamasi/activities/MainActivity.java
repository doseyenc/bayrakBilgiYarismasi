package com.example.bayrakuygulamasi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bayrakuygulamasi.DatabaseCopyHelper;
import com.example.bayrakuygulamasi.R;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button buttonBasla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbCopy();

        buttonBasla=findViewById(R.id.buttonBasla);
        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,oyunActivity.class);
                startActivity(intent);
            }
        });
    }
    public void dbCopy(){
        DatabaseCopyHelper helper =new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();
    }
}