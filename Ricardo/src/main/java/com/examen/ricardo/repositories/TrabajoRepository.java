package com.examen.ricardo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examen.ricardo.entities.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer>{

	@Query("SELECT t FROM Trabajo t WHERE upper(t.nombre) LIKE upper(concat('%',:cadena,'%'))")
	List<Trabajo> findByNameLike(String cadena);
}
