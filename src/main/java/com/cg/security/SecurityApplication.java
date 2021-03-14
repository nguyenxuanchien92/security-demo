package com.cg.security;

import com.cg.security.cofiguration.CustomSuccessHandler;
import com.cg.security.model.Role;
import com.cg.security.model.User;
import com.cg.security.service.role.IRoleService;
import com.cg.security.service.role.RoleService;
import com.cg.security.service.user.IUserService;
import com.cg.security.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecurityApplication {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    public static void main(String[] args) {

        SpringApplication.run(SecurityApplication.class, args);
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean
    public CustomSuccessHandler customSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
