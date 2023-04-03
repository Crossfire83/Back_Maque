package com.maque.maqueceramica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maque.maqueceramica.models.Carrito;
import com.maque.maqueceramica.models.Usuario;
import com.maque.maqueceramica.services.CarritoService;
import com.maque.maqueceramica.services.UsuarioService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

@RestController // Es un controllar para soportar metodos HTTP
@RequestMapping(path = "/maque_ceramica/carrito/")
public class CarritoController {

	private final CarritoService carritoServicio; // "No nos llames, nosotros te llamamos"

	@Autowired 
	public CarritoController(CarritoService carritoServicio) {
		this.carritoServicio = carritoServicio;
	}

	// HTTP GET
	@GetMapping
	public List<Carrito> getCarrito() {
		return carritoServicio.leerCarrito();
	}


	// HTTP POST
	@PostMapping
	public void postCarrito(@RequestBody Carrito cart) { // No agrego un producto, agrego UN CUERPO a ese producto
		carritoServicio.crearCarrito(cart); // Disparo la operacion CRUD para modificar mi BD
	}

	
	// HTTP DELETE
	@DeleteMapping(path = "{cartId}") // Borrare elementos por ID (miOtso/productos/Id)
	public void deleteCarrito(@PathVariable("cartId") Long cartId) {
		carritoServicio.borrarCarrito(cartId);
	}
	
}