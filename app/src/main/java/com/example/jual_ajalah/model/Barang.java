package com.example.jual_ajalah.model;

public class Barang {

    private int image;
    private String brg_name;
    private String rating;
    private String jenis;
    private String price;

    public Barang() {
    this.image = image;
    this.brg_name = brg_name;
    this.rating = rating;
    this.jenis = jenis;
    this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBrg_name() {
        return brg_name;
    }

    public void setBrg_name(String brg_name) {
        this.brg_name = brg_name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
