package com.maque.maqueceramica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maque.maqueceramica.models.Carrito;
import com.maque.maqueceramica.models.Usuario;
import com.maque.maqueceramica.repositories.CarritoRepository;
import com.maque.maqueceramica.repositories.UsuarioRepository;
@Service
public class CarritoService {
private final CarritoRepository carritoRepository;
	
	//Cableamos usuarioRepository
	@Autowired
	public CarritoService(CarritoRepository carritoRepository) {
		this.carritoRepository = carritoRepository;
	}
	
	//Create // Para agregar objeto
	public void crearCarrito(Carrito cart) { // objeto del tipo producto
		carritoRepository.save(cart);
		} // else //if
	// addProducto

	// Read (Leer una lista de productos)
	public List<Carrito> leerCarrito() {
		return carritoRepository.findAll();
	}// toda la lista de productos


	// Update para actualizar un atributo de usuario


	// Delete
	public void borrarCarrito(Long cId) {
		if (carritoRepository.existsById(cId)) {
			carritoRepository.deleteById(cId);
		}
	}
}
