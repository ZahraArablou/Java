
package com.spring.capp.test;

import com.spring.capp.config.SpringRootConfig;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDataSource {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // System.out.println("---------SQL Excuted-----------------");
       ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
       DataSource ds=(DataSource)ctx.getBean(DataSource.class);  //DataSource(javax.sql) in parent(interface) class and BasicDataSource (apache library)is a implementation class        // System.out.println("---------SQL Excuted-----------------");
        JdbcTemplate jt=new JdbcTemplate(ds);
        String sql="INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`,`password`)VALUES(?,?,?,?,?,?)";
        Object[] param=new Object[]{"Zahra","5145661614","arablouZahra@gmail.com","Brossard","Za","pass1"};

        jt.update(sql,param);
         System.out.println("---------SQL Excuted-----------------");
    }
    
    
}
