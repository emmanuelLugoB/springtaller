package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Cliente;
//posibilita posteriormente utilizar la anotacion Awired
@Repository  //indicamos que manipulara los datos
public class ClienteDao extends DAOGenerico<Cliente> {
	
	@PersistenceContext
	private EntityManager manager;
	
	public ClienteDao() {
		super(Cliente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return manager;
	}

}
