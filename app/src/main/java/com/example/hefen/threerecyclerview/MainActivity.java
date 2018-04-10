package com.example.hefen.threerecyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hefen.threerecyclerview.adapter.MyAdapterA;
import com.example.hefen.threerecyclerview.model.RelatedTopicsItem;
import com.example.hefen.threerecyclerview.model.SimpsonsResponse;
import com.example.hefen.threerecyclerview.network.RetrofitInstance;
import com.example.hefen.threerecyclerview.network.SimpsonsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    AFragment aFragment;
    BFragment bFragment;
    CFragment cFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        aFragment = new AFragment();
        bFragment = new BFragment();
        cFragment = new CFragment();



        SimpsonsService simpsonsService = RetrofitInstance.getRetrofitInstance().create(SimpsonsService.class);

        Call<SimpsonsResponse> call = simpsonsService.getSimpsonsDetails("simpsons+characters", "json");//??????
        Log.i("mylog", "call url: " + call.request().url().toString());
        call.enqueue(new Callback<SimpsonsResponse>() {
            @Override
            public void onResponse(Call<SimpsonsResponse> call, Response<SimpsonsResponse> response) {
                Log.i("mylog", "response: " + response.body().getRelatedTopics().toString());
                List<RelatedTopicsItem> relatedTopics = response.body().getRelatedTopics();
                for (RelatedTopicsItem item : relatedTopics) {
                    String name = item.getText();
                    String description;
                    String image = item.getIcon().getURL();
                    //Log.i("mylog", "obj i = " + i);
                    description = name.substring(name.indexOf("-") + 2);
                    name = name.substring(0, name.indexOf("-"));

                    //Log.i("mylog", name + " " + description);
                    AFragment.titles.add(name);
                    BFragment.titles.add(image);
                    CFragment.titles.add(description);
                }
                addFragment();
            }

            @Override
            public void onFailure(Call<SimpsonsResponse> call, Throwable t) {
                Log.i("mylog", "failure: " + t.getMessage());
            }
        });



    }
    void addFragment() {
        addAFragment();
        addBFragment();
        addCFragment();
    }
    private void addAFragment() {
        fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout_a, aFragment)
                .addToBackStack(null)
                .commit();
    }
    private void addBFragment() {
        fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout_b, bFragment)
                .addToBackStack(null)
                .commit();
    }
    private void addCFragment() {
        fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout_c, cFragment)
                .addToBackStack(null)
                .commit();
    }
}
