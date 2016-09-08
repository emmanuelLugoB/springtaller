package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Usuario;
								//paso de la clase usuario que se convertira en objeto
@Repository //indicamos que manipulara los datos
public class UsuarioDAO extends DAOGenerico<Usuario> {
	
	//contexto de persistencia // manipulador de entidades
	@PersistenceContext
	private EntityManager em;
	
	
	
	public UsuarioDAO() {
		//paso de la clase usuario al dao generico
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
