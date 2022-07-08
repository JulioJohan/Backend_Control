package com.utng.controlescolar.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.sevice.IDinamicoService;


@Repository
public class DinamicoImplRepository implements IDinamicoService  {
	
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Response<Ciclo> findUserByEmails(Set<String> nombres, Set<String> claves) {

		Response<Ciclo> response = new Response<Ciclo>();
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ciclo> query = cb.createQuery(Ciclo.class);

        
        Root<Ciclo> ciclo = query.from(Ciclo.class);
        
        //Path obtener los campos
        Path<String> nombrePath = ciclo.get("nombre");
        Path<String> clavePath = ciclo.get("clave");
//        Path<Date> fecha = ciclo.get("fechaFin");
        
       

        List<Predicate> predicates = new ArrayList<Predicate>();
       
        
        for (String nombre : nombres) {
            predicates.add(cb.like(nombrePath, nombre));
        }
       
        
        for (String clave : claves) {
            predicates.add(cb.like(clavePath, clave));
        }
 
        
           
  
        
        query.select(ciclo)
            .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
        
        	List<Ciclo> lista = entityManager.createQuery(query)
            .getResultList();
        
        	response.setMensaje("Consulta Correcta");
        	response.setStatus("ok");
        	response.setList(lista);
        	return response;
	}


	}

