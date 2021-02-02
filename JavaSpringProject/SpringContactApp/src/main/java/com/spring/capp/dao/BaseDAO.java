/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.capp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;


//do not @Repository or @Service or @Component annotation

abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {
    @Autowired
    public void setDataSource2(DataSource ds){
        super.setDataSource(ds);
    }
    
}
