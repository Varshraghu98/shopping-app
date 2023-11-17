package com.application.shopping.dao.user;

import com.application.shopping.entity.user.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao extends CrudRepository<UserRole, String> {
}
