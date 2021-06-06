package com.example.bayrakuygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BayraklarDao {
    public ArrayList<Bayraklar> getRandomFiveFlag(Veritabani vt){
        ArrayList<Bayraklar> list = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5", null);
        while (c.moveToNext()){
            Bayraklar temp= new Bayraklar(c.getInt(c.getColumnIndex("bayrak_id"))
                    ,c.getString(c.getColumnIndex("bayrak_ad"))
                    ,c.getString(c.getColumnIndex("bayrak_resim")));
            list.add(temp);
        }
        return list;
    }
    public ArrayList<Bayraklar> getRandomWrongFlags(Veritabani vt ,int bayrak_id){
        ArrayList<Bayraklar> list = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != "+bayrak_id+" ORDER BY RANDOM() LIMIT 3", null);
        while (c.moveToNext()){
            Bayraklar temp= new Bayraklar(c.getInt(c.getColumnIndex("bayrak_id"))
                    ,c.getString(c.getColumnIndex("bayrak_ad"))
                    ,c.getString(c.getColumnIndex("bayrak_resim")));
            list.add(temp);
        }
        return list;

    }
}
