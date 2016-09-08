package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Cliente;

@Repository
//Clase encargada de la manipulacion de datos, posibilita posteriormente utilizar la anotacion
//Autowired
public class ClienteDAO extends DAOGenerico<Cliente> {

	@PersistenceContext
	private EntityManager manager;

	public ClienteDAO() {
		// TODO Auto-generated constructor stub
	
	super(Cliente.class);
	}
	
	
	public void save(Cliente cliente){

				//metodo para insertar los datos
		manager.persist(cliente);
	}


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
