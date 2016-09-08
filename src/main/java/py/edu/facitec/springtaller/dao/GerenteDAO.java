package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Gerente;
@Repository
public class GerenteDAO extends DAOGenerico<Gerente>{

	@PersistenceContext
	private EntityManager manager;

	public GerenteDAO() {
		super(Gerente.class);
	}

	public void save(Gerente gerente){

		//metodo para insertar los datos
		manager.persist(gerente);
	}


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
