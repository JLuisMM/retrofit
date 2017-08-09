package com.example.luis.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StudentService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StudentService studentsService = retrofit.create(StudentService.class);

        studentsService.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> students = response.body();

                for (Student student : students)
                {
                    Log.d(TAG, "doMagic: " + student);
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {}
        });
    }
}
