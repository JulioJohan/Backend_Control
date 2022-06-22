package com.utng.controlescolar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.utng.controlescolar.model.Materia;


//repositorio 
public interface  MateriaRepository  extends JpaRepository<Materia, Integer>{
	
	@Query("select a from Materia a where a.nombre = ?1 and a.clave = ?2") //?1 hace referencia a un parametro posicionalen "?1" se puede sustituir por :nombre y agregando @params("nombre") en la parte de abajo
	Optional<Materia> consultarPorNombreClave(String nombre, String clave);
	
	
}
