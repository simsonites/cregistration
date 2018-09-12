package com.softpager.cregistration.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CRPWebMvcServletInitializer extends
                                                               AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] {CRPWebMvcConfig.class, CRPHibernateConfig.class};
	}

	@Override
	protected String[] getServletMappings() {		
		return new String[] {"/"};
	}

}
