
package com.spring.capp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ContactAppDispacherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
//Dispatcher is responsible for all the requests and send the requests to controller
    @Override
    protected Class<?>[] getRootConfigClasses() {
      return  new Class[]{SpringRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
      return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext); //To change body of generated methods, choose Tools | Templates. MUST PRESENT
        //Configure global task here if required
    }
    
}
