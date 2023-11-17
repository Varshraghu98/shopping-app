package com.application.shopping.entity.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductDetails {

    private Integer productId;

    private Integer productQuantity;
}
