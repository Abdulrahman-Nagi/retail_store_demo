package com.ups.retailstore.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "retail_product")
public class RetailProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;


    @ManyToOne(fetch = FetchType.LAZY)
    private RetailOrder retailOrder;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public RetailOrder getRetailOrder() {
        return retailOrder;
    }

    public void setRetailOrder(RetailOrder retailOrder) {
        this.retailOrder = retailOrder;
    }
}
