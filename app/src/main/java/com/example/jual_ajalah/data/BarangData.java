package com.example.jual_ajalah.data;

import com.example.jual_ajalah.R;
import com.example.jual_ajalah.model.Barang;

import java.util.ArrayList;

public class BarangData {

    private static String [] name = {

            "Pokemon Battle",
            "Forgotten Fields",
            "Resident Evil (1996)",
            "The Legend of Zelda"
    };

    private static String [] rating = {

            "1",
            "2",
            "3",
            "4",
            "5"
    };

    private static String [] price = {
            "Rp. XXX.XXX.XXX",
            "Rp. XXX.XXX.XXX",
            "Rp. XXX.XXX.XXX",
            "Rp. XXX.XXX.XXX"
    };

    private static String [] jenis = {
            "Game",
            "Game",
            "Game",
            "Game",
    };

    private static int [] image = {
            R.drawable.pokemon,
            R.drawable.forgotten_fields,
            R.drawable.re_1996,
            R.drawable.the_legend_of_zelda
    };

    public static ArrayList<Barang> getListData(){
        ArrayList<Barang> list = new ArrayList<>();
        for (int position = 0 ; position < name.length; position++){
            Barang barang = new Barang();
            barang.setRating(rating[position]);
            barang.setBrg_name(name[position]);
            barang.setPrice(price[position]);
            barang.setJenis(jenis[position]);
            barang.setImage(image[position]);
            list.add(barang);
        }
        return list;
    }
}
