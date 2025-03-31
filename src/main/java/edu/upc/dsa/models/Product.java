package edu.upc.dsa.models;


public class Product {
    String id;
    String name;
    double price;
    int sales;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int sales() {
        return this.sales;
    }

    public double getPrice() {
        return this.price;
    }

    public void UpSales() {
        ++this.sales;
    }

    public String getName() {
        return this.name;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
