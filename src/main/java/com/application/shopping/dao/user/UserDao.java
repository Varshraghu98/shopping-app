package com.application.shopping.dao.user;


import com.application.shopping.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao extends CrudRepository<User,String> {

}
