package com.maque.maqueceramica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maque.maqueceramica.models.Usuario;
import com.maque.maqueceramica.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	//Cableamos usuarioRepository
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	//Create // Para agregar objeto
	public void crearUsuario(Usuario user) { // objeto del tipo producto
		Optional<Usuario> correoBuscado = usuarioRepository.findByCorreo(user.getCorreo());
		if (correoBuscado.isPresent()) {
			throw new IllegalStateException("El usuario con el correo " + "[" + user.getCorreo() + "] ya existe.");
		} else {
			usuarioRepository.save(user);
		} // else //if
	}// addProducto

	// Read (Leer una lista de productos)
	public List<Usuario> leerUsuarios() {
		return usuarioRepository.findAll();
	}// toda la lista de productos

	// Read (leer un usuario con un id especifico)
	public Usuario leerUsuario(Long userId) {
		return usuarioRepository.findById(userId)
				.orElseThrow(() -> new IllegalStateException("El Producto " + "con el id " + userId + " no existe."));
	}// getProducto

	// Update para actualizar un atributo de usuario

	public void actualizarUsuario(Long userId, String nombre, String apellido, String telefono) {
		// Si el producto existe...
		if (usuarioRepository.existsById(userId)) {
			// Entonces lo modifico
			Usuario usuarioABuscar = usuarioRepository.getById(userId);// ya que verifico que existe, lo traigo y lo
																			// asigno a una variable llamada
																			// usuarioABuscar
			if (nombre != null)
				usuarioABuscar.setNombre(nombre);
			if (apellido != null)
				usuarioABuscar.setApellido(apellido);
			if (telefono != null)
				usuarioABuscar.setTelefono(telefono);
			// cuando termino de aditar el objeto
			usuarioRepository.save(usuarioABuscar);
		} else {
			System.out.println("El producto con el id " + userId + " no existe");
		}
	}

	// Delete
	public void borrarUsuario(Long UId) {
		if (usuarioRepository.existsById(UId)) {
			usuarioRepository.deleteById(UId);
		}
	}
}
