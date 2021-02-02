/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.capp.test;

import com.spring.capp.config.SpringRootConfig;
import com.spring.capp.domain.User;
import com.spring.capp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUserServiceRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // JUnit can use here to test
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService=ctx.getBean(UserService.class);
        //the uset details will be taken from User-Reg-Form
        User u=new User();
        u.setName("ali");
        u.setPhone("3214569877");
        u.setEmail("ali@gmail.com");
        u.setAddress("Montreal");
        u.setLoginName("ali1");
        u.setPassword("ali123");
        u.setRole(UserService.ROLE_ADMIN);//Admin Role
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);//Active
       userService.register(u);
        System.out.println("--------------user registred successfully------------------------");
        
    }
    
}
