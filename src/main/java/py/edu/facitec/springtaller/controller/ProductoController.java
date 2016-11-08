package py.edu.facitec.springtaller.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.ProductoDao;
import py.edu.facitec.springtaller.model.Producto;

@RestController
@Transactional
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoDao productoDao;
	
	//**************Primer Metodo - registra un producto************
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)										  
											//Anotacion que carga los datos al objeto producto
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto){
		productoDao.guardar(producto, producto.getId());
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	//**************Segundo Metodo - Obtiene la lista de productos************
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> buscarTodos(){
		List<Producto> productos= productoDao.buscarTodos();
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	//*************Tercer Metodo - Busca por ID*******************
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id){
		Producto productoBuscado= productoDao.buscar(id);
		return new ResponseEntity<Producto>(productoBuscado, HttpStatus.OK);
	}
	
	//*************Tercer Metodo - Elimina por ID*******************
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> eliminar(@PathVariable Integer id){
		Producto productoAElimminar= productoDao.buscar(id);
		if (productoAElimminar==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		productoDao.eliminar(productoAElimminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView formulario(){
		return new ModelAndView("/productos/form");
	}

}
