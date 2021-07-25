package com.semutunic.pesenmlijo.models;

public class ProdukModel {


        String id, namaproduk, kategori, harga, minorder, desc;
        public ProdukModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public  ProdukModel(String id, String namaproduk, String harga){
                this.id         =   id;
                this.namaproduk =   namaproduk;
//                this.kategori   =   kategori;
                this.harga      =   harga;
//                this.minorder   =   minorder;
//                this.desc       =   desc;
        }

}
