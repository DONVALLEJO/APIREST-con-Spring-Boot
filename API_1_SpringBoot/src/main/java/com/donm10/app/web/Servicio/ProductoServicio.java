package com.donm10.app.web.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donm10.app.web.modelo.Producto;
import com.donm10.app.web.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
	@Autowired
	private ProductoRepositorio repositorio;
	
	public List<Producto> listarProductos(){
		return repositorio.findAll();
		
	}

	public void guardarProductos(Producto producto){
		repositorio.save(producto);
		
	}
	
	public Producto obtenerProductoporID(Integer id) {
		return repositorio.findById(id).get();
		}
	
	
    public void eliminarProducto(Integer id) {
    	repositorio.deleteById(id);
    }
           
	}
