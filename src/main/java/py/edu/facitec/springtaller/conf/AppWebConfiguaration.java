package py.edu.facitec.springtaller.conf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import py.edu.facitec.springtaller.controller.HomeController;
//activa el compponente mvc de spring para trabajar con servlet
@EnableWebMvc
//carga las clases necesarias para iniciar la aplicacion
@ComponentScan(basePackageClasses={HomeController.class})
public class AppWebConfiguaration extends WebMvcConfigurerAdapter{
	//gestiona como un nuevo componente de la aplicacion
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		
		
		resolver.setPrefix("/WEB-INF/views/");
	
		resolver.setSuffix(".jsp");
		
		return resolver;
	
	}
}