package com.maque.maqueceramica;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.maque.maqueceramica.models.Carrito;
import com.maque.maqueceramica.models.Productos;
import com.maque.maqueceramica.models.Usuario;
import com.maque.maqueceramica.repositories.CarritoRepository;

@DataJpaTest
@AutoConfigureTestDatabase (replace = Replace.NONE)
@Rollback(false)
public class CarritoTest {
	
	@Autowired
	private CarritoRepository cartRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void testAddOneCartItem() {
		Productos product = entityManager.find(Productos.class, 3L);
		Usuario user = entityManager.find(Usuario.class, 2L);
		
		Carrito newItem = new Carrito();
		newItem.setUsuario(user);
		newItem.setProductos(product);
		newItem.setCantidad(1);
		
		Carrito saveCarrito = cartRepo.save(newItem);
		
		assertTrue(saveCarrito.getId() > 0);
		
		
	}


}
