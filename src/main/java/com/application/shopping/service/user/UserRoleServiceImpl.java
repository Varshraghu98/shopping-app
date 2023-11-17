package com.application.shopping.service.user;

import com.application.shopping.dao.user.UserRoleDao;
import com.application.shopping.entity.user.UserRole;
import com.application.shopping.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public UserRole createUserRole(UserRole role) {
       return userRoleDao.save(role);
    }

}
