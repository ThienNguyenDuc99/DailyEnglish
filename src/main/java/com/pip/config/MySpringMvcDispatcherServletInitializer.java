package com.pip.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { DemoAppConfig.class };
    }

    // Khi bắn lên browser nó sẽ hiện cái /, nếu để /home thì browser sẽ hiện cái /home đầu tiên
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}






