package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Departamento;

@Repository
public class DepartamentoDAO extends DAOGenerico<Departamento> {
	@PersistenceContext
	private EntityManager manager;

	public DepartamentoDAO() {
		// TODO Auto-generated constructor stub
		super(Departamento.class);	
	}
	
	public void save(Departamento departamento){

				//metodo para insertar los datos
		manager.persist(departamento);
	}


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
