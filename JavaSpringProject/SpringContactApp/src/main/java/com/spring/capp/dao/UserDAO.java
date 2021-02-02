/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.capp.dao;

import com.spring.capp.domain.User;
import java.util.List;


public interface UserDAO {

    public void save(User u);

    public void update(User u);

    public void delete(User u);

    public void findById(User u);

    public void delete(Integer userId);

    public User findById(Integer userId);

    public List<User> findAll();

    public List<User> findByProperty(String propName, Object propValue);//property value can be any type integer, string,boolean,float

}
