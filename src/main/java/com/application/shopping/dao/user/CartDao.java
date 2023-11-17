package com.application.shopping.dao.user;

import com.application.shopping.entity.user.Cart;
import com.application.shopping.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartDao extends CrudRepository<Cart,Integer> {

    List<Cart> findByUser(User user);

}
