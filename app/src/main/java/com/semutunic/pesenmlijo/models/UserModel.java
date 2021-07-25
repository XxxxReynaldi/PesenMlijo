package com.semutunic.pesenmlijo.models;

public class UserModel {

    private String Nama, Alamat, NoTelp, Email;
    private int RoleID;

    private ProvinsiModel Provinsi;
    private KotaKabupatenModel KotaKabupaten;
    private KecamatanModel Kecamatan;

    private String JamBuka;
    private String JamTutup;


    public UserModel() {
        // public no arg constructor need
    }

    // untuk Pendaftaran user
    public UserModel(String nama, String alamat, String noTelp, String email, int roleID) {
        Nama = nama;
        Alamat = alamat;
        NoTelp = noTelp;
        Email = email;
        RoleID = roleID;
    }

    // untuk Update Profile
    public UserModel(String nama, String alamat, String noTelp, String email, ProvinsiModel provinsi, KotaKabupatenModel kotaKabupaten, KecamatanModel kecamatan, String jamBuka, String jamTutup, int roleID) {
        Nama = nama;
        Alamat = alamat;
        NoTelp = noTelp;
        Email = email;
        Provinsi = provinsi;
        KotaKabupaten = kotaKabupaten;
        Kecamatan = kecamatan;
        JamBuka = jamBuka;
        JamTutup = jamTutup;
        RoleID  = roleID;
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

    public ProvinsiModel getProvinsi() {
        return Provinsi;
    }

    public void setProvinsi(ProvinsiModel provinsi) {
        Provinsi = provinsi;
    }

    public KotaKabupatenModel getKotaKabupaten() {
        return KotaKabupaten;
    }

    public void setKotaKabupaten(KotaKabupatenModel kotaKabupaten) {
        KotaKabupaten = kotaKabupaten;
    }

    public KecamatanModel getKecamatan() {
        return Kecamatan;
    }

    public void setKecamatan(KecamatanModel kecamatan) {
        Kecamatan = kecamatan;
    }

    public String getJamBuka() {
        return JamBuka;
    }

    public void setJamBuka(String jamBuka) {
        JamBuka = jamBuka;
    }

    public String getJamTutup() {
        return JamTutup;
    }

    public void setJamTutup(String jamTutup) {
        JamTutup = jamTutup;
    }
}
