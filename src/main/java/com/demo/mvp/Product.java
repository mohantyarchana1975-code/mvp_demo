package com.demo.mvp;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private String category;
    private String unit;
    private double price;

    public Product(){}
    public Product(String sku,String name,String category,String unit,double price){
        this.sku=sku;this.name=name;this.category=category;this.unit=unit;this.price=price;
    }
    public Long getId(){return id;}
    public String getSku(){return sku;}
    public String getName(){return name;}
    public String getCategory(){return category;}
    public String getUnit(){return unit;}
    public double getPrice(){return price;}
    public void setId(Long id){this.id=id;}
    public void setSku(String v){this.sku=v;}
    public void setName(String v){this.name=v;}
    public void setCategory(String v){this.category=v;}
    public void setUnit(String v){this.unit=v;}
    public void setPrice(double v){this.price=v;}
}
