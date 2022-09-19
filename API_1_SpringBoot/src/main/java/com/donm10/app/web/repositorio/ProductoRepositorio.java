package com.donm10.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donm10.app.web.modelo.Producto;

public interface ProductoRepositorio  extends JpaRepository<Producto, Integer>{

}
