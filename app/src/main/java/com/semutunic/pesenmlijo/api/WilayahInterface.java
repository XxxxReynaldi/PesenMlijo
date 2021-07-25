package com.semutunic.pesenmlijo.api;

import com.semutunic.pesenmlijo.models.ProvinsiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WilayahInterface {

    String JSONURL = "https://dev.farizdotid.com/api/daerahindonesia/";

    @GET("provinsi")
    Call<String> getProvinsiJSON();

    @GET("kota?id_provinsi={id_provinsi}")
    Call<String> getKotaKabupatenJSON(@Path("id_provinsi")int id);
}
