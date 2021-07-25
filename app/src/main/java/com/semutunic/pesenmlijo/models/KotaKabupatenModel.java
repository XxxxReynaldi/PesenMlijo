package com.semutunic.pesenmlijo.models;

public class KotaKabupatenModel {

    int id;
    String nama;

    public KotaKabupatenModel() {
    }

    public KotaKabupatenModel(int id, String nama) {
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
//        return "KotaKabupatenModel{" +
//                "id=" + id +
//                ", nama='" + nama + '\'' +
//                '}';
        return nama;
    }
}
