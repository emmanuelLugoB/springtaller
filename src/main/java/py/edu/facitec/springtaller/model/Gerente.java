package py.edu.facitec.springtaller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import py.edu.facitec.springtaller.model.general.General;

@Entity
public class Gerente extends General {
	
	private String ci;
	private String nombre;
	@OneToOne(mappedBy="gerente")
	private Departamento departamento;
	
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	

}
