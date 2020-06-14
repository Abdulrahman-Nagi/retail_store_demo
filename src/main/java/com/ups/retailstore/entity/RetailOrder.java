package com.ups.retailstore.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "retail_order")
public class RetailOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;


    @ManyToOne(fetch =FetchType.LAZY)
    private User retailUser;

    @OneToMany(mappedBy ="retailOrder" ,cascade = CascadeType.ALL)
    private List<RetailProduct> retailProductList = new ArrayList<>();



    public void addProduct(RetailProduct product) {
        retailProductList.add(product);
        product.setRetailOrder(this);
    }

    public void removeProduct(RetailProduct product) {
        retailProductList.remove(product);
        product.setRetailOrder(null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getRetailUser() {
        return retailUser;
    }

    public void setRetailUser(User retailUser) {
        this.retailUser = retailUser;
    }
}
