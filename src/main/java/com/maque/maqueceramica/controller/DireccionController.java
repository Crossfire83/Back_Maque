package com.maque.maqueceramica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.maque.maqueceramica.models.Direccion;
import com.maque.maqueceramica.models.Usuario;
import com.maque.maqueceramica.services.DireccionService;
import com.maque.maqueceramica.services.UsuarioService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

@RestController // Es un controllar para soportar metodos HTTP
@RequestMapping(path = "/maque_ceramica/direccion/") /*
												 * Indica la ruta o URL de nestro endpoint para saber donde se manejan
												 * esas solicitudes HTTP
												 */

public class DireccionController {
	
	private final DireccionService direccionServicio; // "No nos llames, nosotros te llamamos"

	@Autowired /*
				 * Se usa para indicar a Spring que inyecte automaticamente una instancia del
				 * productoSericio en la clase ProductoController. Asi nos aseguramos que la
				 * instancia esta disponible y la lista para usarse cuando se necesite en la
				 * clase.
				 */

	// Segunda parte de inyeccion de dependencia
	// Constructor con ese objeto como parametro
	public DireccionController(DireccionService direccionServicio) {
		this.direccionServicio = direccionServicio;
	}

	// HTTP GET
	@GetMapping
	public List<Direccion> getDirecciones() {
		return direccionServicio.leerDirecciones();
	}

	// HTTP GET para un producto
	@GetMapping(path = "{dirId}")
	public Direccion getdireccion(@PathVariable("dirId") Long dirId) {
		return direccionServicio.leerDireccion(dirId);
	}

	// HTTP POST
	@PostMapping
	public void postUsuario(@RequestBody Direccion dir) { // No agrego un producto, agrego UN CUERPO a ese producto
		direccionServicio.crearDireccion(dir); // Disparo la operacion CRUD para modificar mi BD
	}

	// HTTP PUT
	@PutMapping(path = "{dirId}")
	public ResponseEntity<Direccion> actualizarDireccion(@PathVariable Long id, @RequestBody Direccion direccionActualizada) {
	    Direccion direccionExistente = direccionServicio.leerDireccion(id);
	    if (direccionExistente == null) {
	        return ResponseEntity.notFound().build();
	    }
	    direccionActualizada.setId(id);
	    Direccion direccionActualizadaDB = direccionServicio.updateDireccion(direccionActualizada);
	    return ResponseEntity.ok().body(direccionActualizadaDB);
	}

	// HTTP DELETE
	@DeleteMapping(path = "{dirId}") // Borrare elementos por ID (miOtso/direccion/Id)
	public void deleteDireccion(@PathVariable("dirId") Long dirId) {
		direccionServicio.borrarDireccion(dirId);
	}
	
}