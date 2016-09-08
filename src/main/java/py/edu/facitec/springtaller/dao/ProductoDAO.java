package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Producto;

@Repository
public class ProductoDAO  extends DAOGenerico<Producto>{
	@PersistenceContext
	private EntityManager manager;

	public ProductoDAO() {
		// TODO Auto-generated constructor stub
		super(Producto.class);
	}


	public void save(Producto producto){

		//metodo para insertar los datos
		manager.persist(producto);
	}


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}


}
