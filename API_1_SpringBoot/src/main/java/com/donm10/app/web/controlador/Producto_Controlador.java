package com.donm10.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donm10.app.web.Servicio.ProductoServicio;
import com.donm10.app.web.modelo.Producto;

@RestController
public class Producto_Controlador {

	@Autowired
	private ProductoServicio servicio;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return servicio.listarProductos();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProductos(@PathVariable Integer id) {
		try {
			Producto producto = servicio.obtenerProductoporID(id);
			return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/productos")
	private void guardarroducto(@RequestBody Producto producto) {
		servicio.guardarProductos(producto);

	}
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto,@PathVariable Integer id){
		try {
			Producto producto_Actual = servicio.obtenerProductoporID(id);
			
			 producto_Actual.setNombre(producto.getNombre());
			 producto_Actual.setPrecio(producto.getPrecio());
			 servicio.guardarProductos(producto_Actual);
			 
			return new ResponseEntity<Producto>(HttpStatus.OK);
		} catch (Exception excepcion) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("/producto/{id}")
	public void eliminarProducto(@PathVariable Integer id) {
		servicio.eliminarProducto(id);
	}
	
}
