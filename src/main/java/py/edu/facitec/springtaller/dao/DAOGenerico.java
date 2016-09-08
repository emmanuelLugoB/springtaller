package py.edu.facitec.springtaller.dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class DAOGenerico<T> {

	private Class<T> entityClass;

	public DAOGenerico(Class<T> entityClass) {
		this.entityClass=entityClass;
	}	
	protected abstract EntityManager getEntityManager();

public void insertar(T entity){
	getEntityManager().persist(entity);
}
public void actualizar(T entity){
	getEntityManager().merge(entity);
}
public void eliminar(T entity){
    getEntityManager().remove(getEntityManager().contains(entity)?entity:getEntityManager().merge(entity) ); 
}
public T buscar(Object id){
	return getEntityManager().find(entityClass, id);     
}
public List<T> buscarTodos(){ 
	return getEntityManager().createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();     
}   

public void guardar(T entity, Object id){
	if(id==null  || id.equals("")){
		insertar(entity);
		
	}else{
		if(buscar(id)==null){
			actualizar(entity);
			
		}
	}
	
}








}
