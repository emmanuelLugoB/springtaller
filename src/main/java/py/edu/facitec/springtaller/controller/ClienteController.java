package py.edu.facitec.springtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.springtaller.dao.ClienteDAO;
import py.edu.facitec.springtaller.model.Cliente;

@Controller
//Gestionar transaciones
@Transactional

public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;

	@RequestMapping("/clientes")
					//Viene los datos del formulario
					//y se pasa al objeto
	public String save(Cliente cliente){
clienteDAO.guardar(cliente, cliente.getId());
		System.out.println("Registrando el cliente: "+cliente);
		clienteDAO.save(cliente);
		System.out.println("Registrado con éxito!!");
							//Crear la pagina ok.jsp
		return "/clientes/ok";
	}
	//Crear el metodo
	@RequestMapping("/clientes/formulario")
	public String formulario(){
		return "/clientes/formulario";
	}

}

