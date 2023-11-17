package com.application.shopping.service.user;

import com.application.shopping.entity.user.User;

public interface UserService {

   User createUser(User user);

   void initRoleAndUser();
}
