package com.demo.mvp;

import jakarta.persistence.*;

@Entity
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status; // active, paused

    public Supplier(){}
    public Supplier(String name,String status){this.name=name;this.status=status;}
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getStatus(){return status;}
    public void setId(Long id){this.id=id;}
    public void setName(String n){this.name=n;}
    public void setStatus(String s){this.status=s;}
}
