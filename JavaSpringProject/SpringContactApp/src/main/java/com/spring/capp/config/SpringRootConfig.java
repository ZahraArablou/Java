
package com.spring.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sun.jvm.hotspot.debugger.posix.DSO;

@Configuration
@ComponentScan(basePackages = {"com.spring.capp.dao","com.spring.capp.service"})
public class SpringRootConfig {//contains beans related to business or application layer
    //TODO: Services , DAO,DataSource, Email Sender or some other business layer beans
  @Bean
  public BasicDataSource getDataSource(){
  BasicDataSource ds=new BasicDataSource();
  ds.setDriverClassName("com.mysql.jdbc.Driver");
  ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
  ds.setUsername("root");
  ds.setPassword("rootroot");
 
   return ds;
}
}
