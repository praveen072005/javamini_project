package com.example.jewel.jewelmodel;

public class Product {
    private int id;
    private String model_number;
    private int category_id;
    private String name;
    private String imageUrl;

    public Product() {}

    public Product(int id, int category_id, String name,String model_number, String imageUrl) {
        this.model_number = model_number;
        this.category_id = category_id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
    }
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public void setModel_number(String model_number) {this.model_number = model_number;}
    public String getModel_number() {return model_number;}

    public void setName(String name) {this.name = name; }
    public String getName() {return name;}

    public int getCategoryId() { return category_id; }
    public void setCategoryId(int category_id) { this.category_id = category_id; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
