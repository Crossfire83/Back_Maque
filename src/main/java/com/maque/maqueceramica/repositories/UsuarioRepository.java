package com.maque.maqueceramica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maque.maqueceramica.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
@Query("SELECT p FROM Usuario p WHERE p.correo=?1")
	
	/*Metodo que realiza la consulta personalizada definida anteriormente. Retorna un Optional que puede contener un objeto Producto si se encuentra en la base con el nombre especificado, o un Optional vacio si no existe.*/
	Optional<Usuario> findByCorreo(String correo);

}