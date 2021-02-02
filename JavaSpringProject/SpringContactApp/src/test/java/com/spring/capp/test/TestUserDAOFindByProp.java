/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.capp.test;

import com.spring.capp.config.SpringRootConfig;
import com.spring.capp.dao.UserDAO;
import com.spring.capp.domain.User;
import com.sun.tools.javac.comp.Todo;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOFindByProp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // JUnit can use here to test
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        //TODO:the uset details will be taken from User-Reg-Form
      List<User> users=userDAO.findByProperty("role",1);
      for(User u : users)
      {
          System.out.println(u.getUserId()+"   "+u.getName()+"   "+u.getEmail()+"   "+u.getRole());
     //     Todo:access other fields
      }


    }

}
