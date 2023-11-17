package com.application.shopping.entity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class OrderDetailsInput {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    List<ProductDetails> productDetailsList;
}
