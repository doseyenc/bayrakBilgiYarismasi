package com.example.bayrakuygulamasi;

public class Bayraklar {
    private int bayrak_id;
    private String bayrak_adi;
    private String bayrak_resim;

    public Bayraklar() {
    }

    public Bayraklar(int bayrak_id, String bayrak_adi, String bayrak_resim) {
        this.bayrak_id = bayrak_id;
        this.bayrak_adi = bayrak_adi;
        this.bayrak_resim = bayrak_resim;
    }

    public int getBayrak_id() {
        return bayrak_id;
    }

    public void setBayrak_id(int bayrak_id) {
        this.bayrak_id = bayrak_id;
    }

    public String getBayrak_adi() {
        return bayrak_adi;
    }

    public void setBayrak_adi(String bayrak_adi) {
        this.bayrak_adi = bayrak_adi;
    }

    public String getBayrak_resim() {
        return bayrak_resim;
    }

    public void setBayrak_resim(String bayrak_resim) {
        this.bayrak_resim = bayrak_resim;
    }
}
