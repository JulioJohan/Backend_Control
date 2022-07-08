package com.utng.controlescolar.repository;

import javax.persistence.PersistenceContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.CicloFiltroRequest;
@Repository
public class ConsultaFiltroRequest implements IConsultaCicloRepository {
	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	@Override
	public Response<Ciclo> busquedaCiclo(CicloFiltroRequest filtro) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		//<Materia> retornar materia
		CriteriaQuery<Ciclo> cq = cb.createQuery(Ciclo.class);

		Root<Ciclo> root = cq.from(Ciclo.class);
		//Predicate es como un where, es decir, condicicón.
		List<Predicate> predicados = new ArrayList<Predicate>();

		if(filtro.getClave() != null && !filtro.getClave().isEmpty()) {
						//campo que vamos a validar y valor
			predicados.add(cb.like(root.get("clave"), "%" + filtro.getClave() + "%"));
		}

		if(filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {
			predicados.add(cb.like(root.get("nombre"), "%" + filtro.getNombre() + "%"));
			//cq.select(root).where(predicados.toArray(new Predicate[predicados.size()]));
		}
		/*if(filtro.getPeriodo() != null && filtro.getPeriodo() !=0) {
			predicados.add(cb.equal(root.get("periodo"), filtro.getPeriodo() ));
			//cq.select(root).where(predicados.toArray(new Predicate[predicados.size()]));
		}
		/*if(filtro.getFechaInicio().toString().substring(0, 3) != null && filtro.getFechaInicio().toString().substring(0, 3).isEmpty()) {
			predicados.add(cb.equal(root.get("fechaInicio"), filtro.getFechaInicio().toString().substring(0, 3) ));
			//cq.select(root).where(predicados.toArray(new Predicate[predicados.size()]));
		}*/
		
		if(filtro.getAnio() != null && !filtro.getAnio().isEmpty()) {
			String fecha1 = filtro.getAnio() +"-01-01";
			String fecha2 = filtro.getAnio() +"-12-31";
			Date date1 = Date.valueOf(fecha1);
			Date date2 = Date.valueOf(fecha2);
			
			predicados.add(cb.between(root.get("fechaInicio"), date1, date2));
			
			
		}

		if(!predicados.isEmpty()) {
			Predicate[] pr = new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}

		cq.orderBy(cb.desc(root.get("id")));

		CriteriaQuery<Ciclo> select = cq.select(root);

		TypedQuery<Ciclo> typedQuery = em.createQuery(select);

		List<Ciclo> lista = typedQuery.getResultList();
		Response<Ciclo> response = new Response<>();
		response.setList(lista);
		response.setStatus("OK");
		response.setMensaje("Consulta exitosa");
	
		return response;
	}

}

