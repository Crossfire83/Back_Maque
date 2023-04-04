package com.maque.maqueceramica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maque.maqueceramica.models.Direccion;


public interface DireccionRepository extends JpaRepository<Direccion, Long>{
	
	Optional<Direccion> findById(Long id);
}

