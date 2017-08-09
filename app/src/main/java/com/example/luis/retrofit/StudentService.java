package com.example.luis.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by luis on 8/7/17.
 */

interface StudentService
{
    String BASE_URL = "http://www.mocky.io/";

    @GET("/v2/57a01bec0f0000c10d0f650f")
    Call<List<Student>> getStudents();
}
