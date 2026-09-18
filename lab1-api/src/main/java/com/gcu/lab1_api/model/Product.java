package com.gcu.lab1_api.model;

public class Product {
    private String name;
    private double price;
    private String description;
    private int quantity;
    private Long id;

    public Product() {

    }
    public Product(String name, double price, String description, int quantity, Long id) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
