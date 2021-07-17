package com.semutunic.pesenmlijo.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProvinsiModel {
    int id;
    String nama;

    public ProvinsiModel() {
    }

    public ProvinsiModel(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
//        return "ProvinsiModel{" +
//                "nama='" + nama + '\'' +
//                '}';
        return nama;
    }
}
