
package com.spring.capp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//

@Configuration
@ComponentScan(basePackages = {"com.spring"})
@EnableWebMvc //activates MVC configuration , MVC modul
public class SpringWebConfig extends WebMvcConfigurerAdapter { //web related beans
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
       //resource means your static resources contains like css,js,images
       //css file is not accessible whitout this method 
       registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver vr=new InternalResourceViewResolver();//responsile for search the view and give the extension and search the path 
        vr.setViewClass(JstlView.class);//for use the jsp this library is needed, inside the jsp we use jstl code
        vr.setPrefix("/WEB-INF/view/");//path
        vr.setSuffix(".jsp");//extension
        return  vr;
    }
}
