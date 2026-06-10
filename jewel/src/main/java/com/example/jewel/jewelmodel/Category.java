package com.example.jewel.jewelmodel;

public class Category {
    private int id;
    private String name;
    private int jewel_type_id;  // foreign key to JewelType

    public Category() {}

    public Category(int id, String name, int jewel_type_id) {
        this.id = id;
        this.name = name;
        this.jewel_type_id = jewel_type_id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getJewelTypeId() { return jewel_type_id; }
    public void setJewelTypeId(int jewel_type_id) { this.jewel_type_id = jewel_type_id; }
}
