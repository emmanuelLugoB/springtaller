package py.edu.facitec.springtaller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import py.edu.facitec.springtaller.model.general.General;

@Entity
public class ItemPedido extends General{
	
	private int cantidadProducto;
	private double subTotal;
	
	@ManyToOne
	private Producto producto;
	
	@JsonBackReference //Para que sea bi direccional con es otro @jsonmanagedreference
	@ManyToOne
	private Pedido pedido;

	
	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	

}
