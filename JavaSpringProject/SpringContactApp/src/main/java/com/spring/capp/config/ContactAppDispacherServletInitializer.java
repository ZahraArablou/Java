
package com.spring.capp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ContactAppDispacherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
//Dispatcher is responsible for all the requests and send the requests to controller
 //  This servlet should be initialized first to configure the whole spring framework 
    @Override
    protected Class<?>[] getRootConfigClasses() { //will be your spring root config
      return  new Class[]{SpringRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() { //pattern the controller,Mapping the front controller
      return new String[]{"/"};
    }

    @Override 
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //MUST PRESENT
       
    }
    
}
