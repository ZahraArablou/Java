/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.capp.test;

import com.spring.capp.config.SpringRootConfig;
import com.spring.capp.dao.UserDAO;
import com.spring.capp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUserDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // JUnit can use here to test
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        //the uset details will be taken from User-Update-Form
        User u=new User();
        u.setUserId(3);
        u.setName("Sara Heshmati");
        u.setPhone("3214569877");
        u.setEmail("aaa@gmail.com");
        u.setAddress("Toronto");
        u.setLoginName("Sara1");
        u.setPassword("sara123");
        u.setRole(1);//Admin Role
        u.setLoginStatus(1);//Active
        userDAO.update(u);
        System.out.println("--------------Data Updated------------------------");
        
    }
    
}
