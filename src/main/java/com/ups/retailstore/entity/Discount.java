package com.ups.retailstore.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "retail_discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String discountDescription;

    private double discountPercentage;

    @OneToMany(mappedBy = "retailDiscount",cascade = CascadeType.ALL)
    private List<User> retailUsers = new ArrayList<>();



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public List<User> getRetailUsers() {
        return retailUsers;
    }

    public void setRetailUsers(List<User> retailUsers) {
        this.retailUsers = retailUsers;
    }
}
