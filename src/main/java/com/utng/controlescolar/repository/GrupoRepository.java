package com.utng.controlescolar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.utng.controlescolar.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer>{
	
	@Query("select a from Grupo a where a.grupo = ?1 and a.id = ?2") //?1 hace referencia a un parametro posicionalen "?1" se puede sustituir por :nombre y agregando @params("nombre") en la parte de abajo
	Optional<Grupo> consultarPorNombre(String nombre, Integer clave);
	

	@Query("select a from Grupo a where a.grupo LIKE :grupo")
	List<Grupo> consultarPorGrupo3(@Param("grupo") String grupo);

	
}
