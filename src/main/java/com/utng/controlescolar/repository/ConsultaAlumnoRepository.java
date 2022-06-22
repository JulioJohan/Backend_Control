package com.utng.controlescolar.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;

@Repository
public class ConsultaAlumnoRepository implements IConsultaAlumnoRepository {

	
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro) {
		Response<Alumno> response = new Response<Alumno>();
		
		//Crear un query
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		//de la clase materia creando query
		CriteriaQuery<Alumno>alumnoQuery =  criteriaBuilder.createQuery(Alumno.class);
		
		Root<Alumno> alumno = alumnoQuery.from(Alumno.class);
		
		
		List<Predicate> predicados = new ArrayList<Predicate>();
		
		if(filtro.getCorreo() != null && !filtro.getCorreo().isEmpty()) {
			predicados.add(criteriaBuilder.like(alumno.get("correo"), "%" + filtro.getCorreo() + "%"));
		}
		if(filtro.getCurp() != null && !filtro.getCurp().isEmpty()) {
			predicados.add(criteriaBuilder.like(alumno.get("curp"), "%" + filtro.getCurp() + "%"));
		}
		if(filtro.getExpediente() != null && !filtro.getExpediente().isEmpty()) {
			predicados.add(criteriaBuilder.like(alumno.get("expediente"), "%" + filtro.getExpediente() + "%"));
		}
		if(!predicados.isEmpty()) {
			Predicate[]pr = new Predicate[predicados.size()];
			predicados.toArray(pr);
			alumnoQuery.where(pr);
		}
		
	alumnoQuery.orderBy(criteriaBuilder.desc(alumno.get("id")));
	//Proyectar
	CriteriaQuery<Alumno> select = alumnoQuery.select(alumno);
	
	TypedQuery<Alumno> typedQuery = entityManager.createQuery(select);
	
	List<Alumno> lista = typedQuery.getResultList();
	
	response.setList(lista);
	response.setStatus("OK");
	response.setMensaje("Consulta Exitosa!!!");
	
	
		return response;
	}

}
