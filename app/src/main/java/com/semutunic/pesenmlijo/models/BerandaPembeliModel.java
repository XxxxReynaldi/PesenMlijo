package com.semutunic.pesenmlijo.models;

public class BerandaPembeliModel {
    int image;
    String namatoko, namaproduk, harga;


    public BerandaPembeliModel(int image, String namatoko, String namaproduk, String harga) {
        this.image = image;
        this.namatoko = namatoko;
        this.namaproduk = namaproduk;
        this.harga = harga;
    }

    // gambar produk
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    //nama toko
    public String getNamatoko() {
        return namatoko;
    }

    public void setNamatoko(String namatoko) {
        this.namatoko = namatoko;
    }

    //nama produk
    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    //harga produk
    public String getHargaproduk() {
        return harga;
    }

    public void setHargaproduk(String harga) {
        this.harga = harga;
    }
}
