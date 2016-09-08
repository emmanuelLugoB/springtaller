package py.edu.facitec.springtaller.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer { 
	   
	@Override 
	protected Class<?>[] getRootConfigClasses() {  
		return new Class[]{AppWebConfiguration.class, JPAConfiguration.class};
	}
	 
	  
	 
	 @Override  
	 protected Class<?>[] getServletConfigClasses() { 
		 
		 return new Class[] {};  
	 }
	 
	 //ServletMappings utilizado anteriormente en el web.xml 
	 @Override 
	 protected String[] getServletMappings() {   
		 return new String[] {"/"};  
		 } 
	 }
	 