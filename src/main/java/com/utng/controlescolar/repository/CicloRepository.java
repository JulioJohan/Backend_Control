package com.utng.controlescolar.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Ciclo;

//como esta el @repository lo metera al contexto

public interface CicloRepository extends JpaRepository<Ciclo, Integer>{
 
	@Query("select a from Ciclo a where a.nombre = ?1 and a.clave = ?2") 
	Optional<Ciclo> consultarPorNombre(String nombre, String clave);

	
	@Query("select a from Ciclo a where a.nombre = :nombre and a.clave = :clave")
	Optional<Ciclo> consultarPorNombre2(@Param("nombre") String nombre, @Param("clave") String clave);

	@Query("select a from Ciclo a where a.nombre LIKE :nombre")
	List<Ciclo> consultarPorNombre3(@Param("nombre") String nombre);
	
	
	@Query("select a from Ciclo a where a.clave IN :listaClaves")
	List<Ciclo> consultarPorNombre4(@Param("listaClaves") List<String> listaClaves);
	
	
}

	 




