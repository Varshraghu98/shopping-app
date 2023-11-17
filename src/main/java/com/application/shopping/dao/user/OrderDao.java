package com.application.shopping.dao.user;

import com.application.shopping.entity.user.OrderDetails;
import com.application.shopping.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<OrderDetails, Integer> {

    List<OrderDetails> findByUser(User user);

    List<OrderDetails> findByOrderStatus(String status);

}
