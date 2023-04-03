package com.maque.maqueceramica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maque.maqueceramica.models.Productos;
import com.maque.maqueceramica.repositories.ProductoRepository;

@Service
public class ProductoService {

	// Creo el objeto de la clase ProductoRepository
	private final ProductoRepository productoRepository;

	// Cablear con el autowired
	@Autowired
	// Uso ese objeto como parametro de mi constructor
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	
	/*  Create(Metodo para agregar un objeto del tipo Producto y guardarlo en la base
	 * de datos). Si el producto existe no deberia actualizar la base de datos
	 * porque seria un objeto duplicado.
	 */
	public void crearProducto(Productos prod) { // objeto del tipo producto
		Optional<Productos> productoBuscado = productoRepository.findByNombre(prod.getNombre());
		if (productoBuscado.isPresent()) {
			throw new IllegalStateException("El producto con el nombre " + "[" + prod.getNombre() + "] ya existe.");
		} else {
			productoRepository.save(prod);
		} // else //if
	}// addProducto

	// Read (Leer una lista de productos)
	public List<Productos> leerProductos() {
		return productoRepository.findAll();
	}// toda la lista de productos

	// Read (leer un producto con un id especifico)
	public Productos leerProducto(Long prodId) {
		return productoRepository.findById(prodId)
				.orElseThrow(() -> new IllegalStateException("El Producto " + "con el id " + prodId + " no existe."));
	}// getProducto

	// Update para actualizar un producto

	public void actualizarProducto(Long prodId, String nombre, String descripcion, String uRL_Imagen, double precio) {
		// Si el producto existe...
		if (productoRepository.existsById(prodId)) {
			// Entonces lo modifico
			Productos productoABuscar = productoRepository.getById(prodId);// ya que verifico que existe, lo traigo y lo
																			// asigno a una variable llamada
																			// productoABuscar
			if (nombre != null)
				productoABuscar.setNombre(nombre);
			if (descripcion != null)
				productoABuscar.setDescripcion(descripcion);
			if (precio != 0)
				productoABuscar.setPrecio(precio);
			if (uRL_Imagen != null)
				productoABuscar.setuRL_Imagen(uRL_Imagen);
			// cuando termino de aditar el objeto
			productoRepository.save(productoABuscar);
		} else {
			System.out.println("El producto con el id " + prodId + " no existe");
		}
	}

	// Delete
	public void borrarProducto(Long proId) {
		if (productoRepository.existsById(proId)) {
			productoRepository.deleteById(proId);
		}
	}

}
