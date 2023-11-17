package com.application.shopping.entity.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    private String productName;

    private String productDescription;

    private Double productPrice;

    private Double productDiscountedPrice;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="product_images",
    joinColumns = {
            @JoinColumn(name= "product_id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "image_id")
            }

    )
    private Set<ImageModel> productImages;
}
