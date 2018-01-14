package com.example.mahe.task_8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.widget.Toast;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    public ArrayList<String> movieList = new ArrayList<>();
    public ArrayList<String> cast = new ArrayList<>();
    public ArrayList<String> desc = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.simplifiedcoding.net/demos/").addConverterFactory(GsonConverterFactory.create()).build();
        api apiobj = retrofit.create(api.class);
        Call<List<Mov>> call = apiobj.getMov();
        call.enqueue(new Callback<List<Mov>>() {
            @Override
            public void onResponse(Call<List<Mov>> call, Response<List<Mov>> response)
            {
                List<Mov> movies = response.body();
                for(Mov m : movies)
                {
                    movieList.add(m.getName());
                    desc.add(m.getBio());
                }
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
                RecyclerAdapter adapter = new RecyclerAdapter(movieList,desc);
                RecyclerView.LayoutManager layoutManger = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManger);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Mov>> call, Throwable t)
            {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
