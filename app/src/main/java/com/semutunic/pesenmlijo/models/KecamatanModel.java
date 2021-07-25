package com.semutunic.pesenmlijo.models;

public class KecamatanModel {
    int id;
    String nama;

    public KecamatanModel() {
    }

    public KecamatanModel(int id, String nama) {
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
}
