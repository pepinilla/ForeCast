package com.example.carolina.forecast.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;


import com.example.carolina.forecast.R;
import com.example.carolina.forecast.entities.Locations;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 02/06/17.
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {
    private List<Locations> list;
    private OnItemClickListener clickListener;


    public CustomRecyclerAdapter() {
        this.list = new ArrayList<Locations>();
    }



    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fragment, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Locations locations = list.get(position);
        String place = locations.getLocation();
        holder.textView.setText(place);

        if (this.clickListener != null){
            holder.setOnItemClickListener(locations, this.clickListener);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addToList(Locations locations){
        list.add(0, locations);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        @Bind(R.id.places)
        TextView textView;


        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setOnItemClickListener (final Locations element, final OnItemClickListener clickListener){
            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(element);

                }
            });
        }
    }
}
