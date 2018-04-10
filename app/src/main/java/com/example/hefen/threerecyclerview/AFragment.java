package com.example.hefen.threerecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hefen.threerecyclerview.R;
import com.example.hefen.threerecyclerview.adapter.MyAdapterA;

import java.util.ArrayList;
import java.util.List;

public class AFragment extends Fragment {
    View rootView;//used to init listview
    RecyclerView recyclerViewSimpsons;
    Context context;
    MyAdapterA adapter;
    public static List<String> titles = new ArrayList<>();
    //SendMessage sendMessage;
    RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        //Log.i("mylog", "on create fragment");
        initList();

        return rootView;
    }

    private void initList() {

        context = rootView.getContext();
        recyclerViewSimpsons = rootView.findViewById(R.id.recyclerView);

        recyclerViewSimpsons.setLayoutManager(new LinearLayoutManager(context));

        recyclerViewSimpsons.setHasFixedSize(true);


        adapter = new MyAdapterA(titles, context);
        //adapter.setPersonModifier(this);//??this context
        recyclerViewSimpsons.setAdapter(adapter);

        //Log.i("mylog", "init list");

    }

}
