package com.demo.mvp;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @ManyToOne
    private Supplier supplier;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public PurchaseOrder(){}
    public PurchaseOrder(String number,Supplier supplier,LocalDate date,OrderStatus status){
        this.number=number;this.supplier=supplier;this.date=date;this.status=status;
    }
    public Long getId(){return id;}
    public String getNumber(){return number;}
    public Supplier getSupplier(){return supplier;}
    public LocalDate getDate(){return date;}
    public OrderStatus getStatus(){return status;}
    public void setId(Long id){this.id=id;}
    public void setNumber(String v){this.number=v;}
    public void setSupplier(Supplier v){this.supplier=v;}
    public void setDate(LocalDate v){this.date=v;}
    public void setStatus(OrderStatus v){this.status=v;}
}
