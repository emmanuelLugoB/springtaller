package py.edu.facitec.springtaller.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import py.edu.facitec.springtaller.controller.HomeControler;
import py.edu.facitec.springtaller.dao.ClienteDao;
import py.edu.facitec.springtaller.model.Producto;
import py.edu.facitec.springtaller.viewresolver.CustomXMLViewResolver;
import py.edu.facitec.springtaller.viewresolver.JsonViewResolver;

//activa los compontes MVC de spring para trabajar el servlet 
@EnableWebMvc
//carga las clase necesarias para iniciar las aplicaciones
@ComponentScan(basePackageClasses={HomeControler.class, ClienteDao.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	//Gestiona como un nuevo componente de la aplicacion
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//configuracion necesarias para habilitar peticiones de recusros estaticos: css javascript y etc
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { 
 	 	configurer.enable(); 
 	} 
 	
	//configuracion para convertir fecha a un formato especifico
 	@Bean  	
 	public FormattingConversionService mvcConversionService() { 
 	 	DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);  	
 	 	DateFormatterRegistrar registrar = new DateFormatterRegistrar();  	
 	 	registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));  	
 	 	registrar.registerFormatters(conversionService); 
 	 	return conversionService; 
 	 } 
 	
 	@Bean  
 	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) { 
 		List<ViewResolver> resolvers = new ArrayList<ViewResolver>(); 
 		resolvers.add(internalResourceViewResolver());  	 	
 		resolvers.add(new JsonViewResolver()); 
 		resolvers.add(getMarshallingXmlViewResolver()); 
 		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver(); 
 		resolver.setViewResolvers(resolvers); 
 		resolver.setContentNegotiationManager(manager); 
 		return resolver; 
 	} 

 	@Bean 
 	public CustomXMLViewResolver getMarshallingXmlViewResolver() {
 		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();  	 	
 		marshaller.setClassesToBeBound(Producto.class); 
 		return new CustomXMLViewResolver(marshaller); 
 	}


 	
		
}
