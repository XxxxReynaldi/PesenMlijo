package com.semutunic.pesenmlijo.model;

public class ProdukModel {


        private int id;
        private int image_produk;
        private String namaproduk;
        private double hargaproduk;
//        private String shortdesc;
//        private double rating;



        public ProdukModel(int id, String namaproduk, double hargaproduk, int image_produk) {
            this.id = id;
            this.image_produk = image_produk;
            this.namaproduk = namaproduk;
            this.hargaproduk = hargaproduk;

//            this.shortdesc = shortdesc;
//            this.rating = rating;

        }

        public int getId() {
            return id;
        }

        public int getImage() {
            return image_produk;
        }

        public String getNamaProduk() {
            return namaproduk;
        }

        public double getHargaProduk() {
            return hargaproduk;
        }


//        public String getShortdesc() {
//            return shortdesc;
//        }

//        public double getRating() {
//            return rating;
//        }


    }