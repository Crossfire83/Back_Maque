package com.maque.maqueceramica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maque.maqueceramica.models.Direccion;
import com.maque.maqueceramica.models.Usuario;
import com.maque.maqueceramica.repositories.DireccionRepository;
import com.maque.maqueceramica.repositories.UsuarioRepository;

@Service
public class DireccionService {

	private final DireccionRepository direccionRepository;

	// Cableamos usuarioRepository
	@Autowired
	public DireccionService(DireccionRepository direccionRepository) {
		this.direccionRepository = direccionRepository;
	}

	// Create // Para agregar objeto
	public Direccion crearDireccion(Direccion dir) { // objeto del tipo producto
		return direccionRepository.save(dir);
	}// addProducto

	// Read (Leer una lista de direcciones)
	public List<Direccion> leerDirecciones() {
		return direccionRepository.findAll();
	}// toda la lista de productos

	// Read (leer una direccion con un id especifico)
	public Direccion leerDireccion(Long dirId) {
		return direccionRepository.findById(dirId)
				.orElseThrow(() -> new IllegalStateException("La direccion " + "con el id " + dirId + " no existe."));
	}// getProducto

	// Update para actualizar un atributo de usuario

	public Direccion updateDireccion(Direccion direccion) {
	    if (direccion.getId() == null) {
	        throw new IllegalArgumentException("La dirección debe tener un ID");
	    }
	    return direccionRepository.save(direccion);
	}

	// Delete
	public void borrarDireccion(Long dirId) {
		if (direccionRepository.existsById(dirId)) {
			direccionRepository.deleteById(dirId);
		}
	}

}
