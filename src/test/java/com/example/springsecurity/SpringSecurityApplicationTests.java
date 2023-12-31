package com.example.springsecurity;

import com.example.springsecurity.mapper.RoleResourceMapper;
import com.example.springsecurity.pojo.UserAuth;
import com.example.springsecurity.security.SecurityConfig;
import com.example.springsecurity.security.service.LoginService;
import com.example.springsecurity.service.Impt.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
class SecurityTests {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Test
     void demo() {
        userDetailsService.loadUserByUsername("hiiro");
    }

    @Test
    void listPermsByUserId() {
        System.out.println(roleResourceMapper.listPermsByUserId(3));
    }

    @Autowired
    private LoginService loginService;
    @Test
    void setLoginService() {
        UserAuth user =new UserAuth();
        user.setUsername("hiiro");
        user.setPassword("hiiro");
        loginService.login(user);
    }

    /**
     * BCrypt加密
     */
    @Autowired
    private SecurityConfig securityConfig;
    @Test
    void setBCrypt() {
        System.out.println("密碼通過BCrypt加密后為");
        System.out.println(securityConfig.passwordEncoder().encode("hiiro"));
    }
}
