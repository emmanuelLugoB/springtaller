package py.edu.facitec.springtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.ClienteDao;
import py.edu.facitec.springtaller.model.Cliente;

//gestiona transasiones
@Transactional
@Controller
//generacion de JSon
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	//injecta una dependencia
	@Autowired
	private ClienteDao clienteDao;
					//responde a peticiones post
	@RequestMapping (method=RequestMethod.POST)
	              //save: vienen los datos del formulario y se pasan a objeto
	public ModelAndView save (@RequestBody Cliente cliente){
		clienteDao.guardar(cliente, cliente.getId());
		System.out.println("Registrando el cliente"+cliente);
		
		        //crea la pagina ok.jsp
		return new ModelAndView("/clientes/ok");
	}
	
	@RequestMapping(value="/formulario", method=RequestMethod.GET) 
	public String formulario(){
		System.out.println("");
		return "/clientes/formulario";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista(){
												//crear el archivo lista.jsp para visualizar
		ModelAndView model = new ModelAndView("/clientes/lista");
		//agregamos la lista de clientes al objeto que contendra la vista
		model.addObject("clientes", clienteDao.buscarTodos());
		return model;
	}

}
