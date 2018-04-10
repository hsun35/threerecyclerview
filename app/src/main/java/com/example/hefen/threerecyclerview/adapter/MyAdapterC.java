package com.example.hefen.threerecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hefen.threerecyclerview.R;

import java.util.List;

public class MyAdapterC extends  RecyclerView.Adapter<MyAdapterC.MyViewHolder>{
    List<String> simpsonsList;
    Context context;


    public MyAdapterC(List<String> simpsonsList, Context context) {
        this.simpsonsList = simpsonsList;
        this.context = context;
    }


    @Override
    public MyAdapterC.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;// = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_c, parent, false);

        final MyAdapterC.MyViewHolder myViewHolder = new MyAdapterC.MyViewHolder(v);


        return myViewHolder;
        //return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapterC.MyViewHolder holder, int position) {
        String simpson = simpsonsList.get(position);
        //String imageUrl = simpson.getImageUrl();

        holder.nameTextView.setText(simpson);
        //holder.descriptionTextView.setText(simpson.getDescription());
        //holder.countryTextView.setText(actor.getCountry());



        //Picasso.with(context).load(actor.getImageUrl()).into(holder.imageViewMyImage);//take image url put on image view
    }

    @Override
    public int getItemCount() {
        if (simpsonsList == null) {
            return 0;
        }
        return simpsonsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;// descriptionTextView, countryTextView;
        //ImageView imageViewMyImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.textViewDescription);
            //descriptionTextView = itemView.findViewById(R.id.textViewDescription);
            //countryTextView = itemView.findViewById(R.id.textViewCountry);
            //imageViewMyImage = itemView.findViewById(R.id.imageView);
        }
    }
}
