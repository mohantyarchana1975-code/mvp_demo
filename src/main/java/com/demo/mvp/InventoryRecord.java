package com.demo.mvp;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class InventoryRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private int delta;
    private LocalDate date;

    public InventoryRecord(){}
    public InventoryRecord(Product product,int delta,LocalDate date){
        this.product=product;this.delta=delta;this.date=date;
    }
    public Long getId(){return id;}
    public Product getProduct(){return product;}
    public int getDelta(){return delta;}
    public LocalDate getDate(){return date;}
    public void setId(Long id){this.id=id;}
    public void setProduct(Product p){this.product=p;}
    public void setDelta(int d){this.delta=d;}
    public void setDate(LocalDate d){this.date=d;}
}
