package com.semutunic.pesenmlijo.models;

public class UserModel {

    String Nama, Alamat, NoTelp, Email;
    int RoleID;

    public UserModel() {
        // public no arg constructor need
    }

    public UserModel(String nama, String alamat, String noTelp, String email, int roleID) {
        Nama = nama;
        Alamat = alamat;
        NoTelp = noTelp;
        Email = email;
        RoleID = roleID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getNoTelp() {
        return NoTelp;
    }

    public void setNoTelp(String noTelp) {
        NoTelp = noTelp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }
}
