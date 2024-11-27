package com.assignment.product_category.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private int pid;
    private String pname;
    private String pdescription;
    private double price;

    @ManyToOne
    @JoinColumn(name = "cid", nullable = false)
    @JsonBackReference
    private Category category;

}
