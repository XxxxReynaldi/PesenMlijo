package com.semutunic.pesenmlijo.models;

public class DalamPengirimanPenjualModel {
    int image;
    String jumlahproduk, namapembeli, tanggal;

    public DalamPengirimanPenjualModel(int image, String tanggal, String namapembeli, String jumlahproduk) {
        this.image = image;
        this.tanggal = tanggal;
        this.namapembeli = namapembeli;
        this.jumlahproduk = jumlahproduk;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    public String getJumlahproduk() {
        return jumlahproduk;
    }

    public void setJumlahproduk(String jumlahproduk) {
        this.jumlahproduk = jumlahproduk;
    }
}
