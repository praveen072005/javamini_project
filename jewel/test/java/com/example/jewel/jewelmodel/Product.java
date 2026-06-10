package com.example.jewel.jewelmodel;

public class Product {
    private int id ;
    private String name;
    private String model_number;
    private String imageurl;
    private int category_id;
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setModel_number(String model_number) {
        this.model_number = model_number;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getModel_number() {
        return model_number;
    }
    public String getImageurl() {
        return imageurl;
    }
    public int getCategory_id() {
        return category_id;
    }
}
