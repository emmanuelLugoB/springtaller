package py.edu.facitec.springtaller.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import py.edu.facitec.springtaller.model.general.General;

@Entity
public class Pedido extends General{
	
	private Date fechaToma;
	private Date fechaEntrega;
	private Double total;
	//indica que es de uno a muchos y facilita la creacion de la clave foranea
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Usuario usuario;
	
	@JsonIdentityReference   // para que la lista sea importante 
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;
	
	
	public Date getFechaToma() {
		return fechaToma;
	}
	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}
	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}
	
	

}
