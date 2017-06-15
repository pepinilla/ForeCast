package com.example.carolina.forecast.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.carolina.forecast.DetailForeCast;
import com.example.carolina.forecast.R;
import com.example.carolina.forecast.adapter.CustomRecyclerAdapter;
import com.example.carolina.forecast.adapter.OnItemClickListener;
import com.example.carolina.forecast.entities.Locations;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 03/06/17.
 */

public class Location_fragment extends Fragment implements OnItemClickListener, ListFragmentListener {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    CustomRecyclerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_places, container, false);
        ButterKnife.bind(this, view);
        setAdapter();
        setRecyclerView();
        return view;

    }

    private void setAdapter(){
        if (adapter == null){
            adapter = new CustomRecyclerAdapter();
            adapter.setOnItemClickListener(this);
        }
    }

    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Locations locations) {
        Intent i = new Intent(getActivity(), DetailForeCast.class);

        i.putExtra(DetailForeCast.LOCATION, locations.getLocation());
        startActivity(i);
    }

    @Override
    public void addToList(Locations locations) {
        adapter.addToList(locations);
    }
}
