package com.application.shopping.controller.user;

import com.application.shopping.entity.user.UserRole;
import com.application.shopping.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping({"/createUserRole"})
    public UserRole createUserRole(@RequestBody UserRole role) {
        return userRoleService.createUserRole(role);
    }

}
