package com.application.shopping.service.user;


import com.application.shopping.dao.user.UserDao;
import com.application.shopping.dao.user.UserRoleDao;
import com.application.shopping.entity.user.User;
import com.application.shopping.entity.user.UserRole;
import com.application.shopping.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        UserRole adminRole = new UserRole();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        userRoleDao.save(adminRole);

        UserRole userRole = new UserRole();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        userRoleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUsername("admin123");
        adminUser.setPassword(getEncodedPassword("admin@pass"));
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        Set<UserRole> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);


        User user = new User();
        user.setUsername("varshini123");
        user.setPassword(getEncodedPassword("test"));
        user.setFirstName("Varshini");
        user.setLastName("Raghunath");
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);

    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public User createUser(User user) {
       UserRole role =  userRoleDao.findById("User").get();
       Set<UserRole> roles = new HashSet<>();
       roles.add(role);
       user.setRole(roles);

       user.setPassword(getEncodedPassword(user.getPassword()));
       return userDao.save(user);
    }
}
