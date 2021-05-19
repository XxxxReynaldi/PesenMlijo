package com.semutunic.pesenmlijo.models;

public class ProdukModel {
    int image;
    String headerP, descP;

    public ProdukModel(int image, String header, String desc) {
        this.image = image;
        this.headerP = header;
        this.descP = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeaderP() {
        return headerP;
    }

    public void setHeaderP(String headerP) {
        this.headerP = headerP;
    }

    public String getDescP() {
        return descP;
    }

    public void setDescP(String descP) {
        this.descP = descP;
    }
}
