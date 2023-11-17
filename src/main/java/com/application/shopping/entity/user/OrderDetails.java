package com.application.shopping.entity.user;

import com.application.shopping.entity.admin.Product;
import com.application.shopping.entity.user.utils.ORDER_STATUS;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Double orderAmount;

    private String orderStatus;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;


    public OrderDetails() {

    }
}
