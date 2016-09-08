package py.edu.facitec.springtaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(){
		//operación a ser realizada 
		System.out.println("Cargando la página"); 
		return "hello-world";
	}
}
