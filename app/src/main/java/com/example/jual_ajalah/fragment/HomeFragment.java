package com.example.jual_ajalah.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jual_ajalah.R;
import com.example.jual_ajalah.adapter.BarangAdapter;
import com.example.jual_ajalah.data.BarangData;
import com.example.jual_ajalah.model.Barang;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Barang> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        list.addAll(BarangData.getListData());
        showRecyclerList();
        return view;

    }

    private void showRecyclerList() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        rv.setLayoutManager(mLayoutManager);
        BarangAdapter barangAdapter = new BarangAdapter(list) {
        };
        rv.setAdapter(barangAdapter);

    }
}
