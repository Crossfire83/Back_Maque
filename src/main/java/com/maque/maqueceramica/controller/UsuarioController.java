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
import com.maque.maqueceramica.models.Usuario;
import com.maque.maqueceramica.services.UsuarioService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

@RestController // Es un controllar para soportar metodos HTTP
@RequestMapping(path = "/maque_ceramica/usuario/") /*
												 * Indica la ruta o URL de nestro endpoint para saber donde se manejan
												 * esas solicitudes HTTP
												 */
public class UsuarioController {
	
	private final UsuarioService usuarioServicio; // "No nos llames, nosotros te llamamos"

	@Autowired /*
				 * Se usa para indicar a Spring que inyecte automaticamente una instancia del
				 * productoSericio en la clase ProductoController. Asi nos aseguramos que la
				 * instancia esta disponible y la lista para usarse cuando se necesite en la
				 * clase.
				 */

	// Segunda parte de inyeccion de dependencia
	// Constructor con ese objeto como parametro
	public UsuarioController(UsuarioService usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}

	// HTTP GET
	@GetMapping
	public List<Usuario> getUsuario() {
		return usuarioServicio.leerUsuarios();
	}

	// HTTP GET para un producto
	@GetMapping(path = "{userId}")
	public Usuario getUsuario(@PathVariable("userId") Long userId) {
		return usuarioServicio.leerUsuario(userId);
	}

	// HTTP POST
	@PostMapping
	public void postUsuario(@RequestBody Usuario user) { // No agrego un producto, agrego UN CUERPO a ese producto
		usuarioServicio.crearUsuario(user); // Disparo la operacion CRUD para modificar mi BD
	}

	// HTTP PUT
	@PutMapping(path = "{userId}")
	public void updateUsuario(@PathVariable("userId") Long userId, 
		
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellido, 
			@RequestParam(required = false) String telefono) {
		usuarioServicio.actualizarUsuario(userId, nombre, apellido, telefono);
			}// updateProducto

	// HTTP DELETE
	@DeleteMapping(path = "{userId}") // Borrare elementos por ID (miOtso/productos/Id)
	public void deleteUsuario(@PathVariable("userId") Long userId) {
		usuarioServicio.borrarUsuario(userId);
	}
	
}
