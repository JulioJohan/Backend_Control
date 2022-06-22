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

import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;


@Repository
public class ConsultaMateriaRepository implements IConsultaMateriaRepository{

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	
	
	@Override
	public Response<Materia> busquedaMateria(MateriaFiltroRequest filtro) {
		
		//Esambla un query 
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//Entidad Materia , creara un query nativo
		CriteriaQuery<Materia> cq = criteriaBuilder.createQuery(Materia.class);
		Response<Materia> response = new Response<Materia>();
		
		//Root = Select 
				//tomando el atributp
				//tomando cq para refereirse que vams a tomar
				Root<Materia> root = cq.from(Materia.class);
				
				//predicados
				//Conculta con el where con condicion
				List<Predicate> predicados = new ArrayList<Predicate>();
				
				if(filtro.getClave() != null && !filtro.getClave().isEmpty()) {
					
//					Predicate condition = cq.select(root).where(criteriaBuilder.like(root.get(filtro.getClave()), "h%"));			
//					predicados.add(criteriaBuilder.equal(root.get("clave"), filtro.getClave()));
					//Comparamos con el like la fila de clave y obtenemos lo que el usuario nos  pone con un %
					//Predicado = a crear un query
					//despues se agregar un metodo y llamams a root para obtener el atributo y traigo el  objeto y traigo el clave con su metodo
					predicados.add(criteriaBuilder.like(root.get("clave"), "%" + filtro.getClave() + "%"));
				
					
				}
				if(filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {
//					predicados.add(criteriaBuilder.equal(root.get("nombre"), filtro.getNombre()));
					predicados.add(criteriaBuilder.like(root.get("nombre"), "%" + filtro.getNombre() + "%"));

				}
				
				if(!predicados.isEmpty()) {
					Predicate[] pr  = new Predicate[predicados.size()];
					//Convierte la lista en un arreglo
					predicados.toArray(pr);
					cq.where(pr);
				}
				
				//Ordernar por el id
				cq.orderBy(criteriaBuilder.desc(root.get("id")));
				
				//proyectara el root
				CriteriaQuery<Materia> select = cq.select(root);
				
				//entityManager para cononectar a la base de datos
				//TypedQuery me regresa la lits
				TypedQuery<Materia>typedQuery = entityManager.createQuery(select);
				
				
				//
				List<Materia> lista =  typedQuery.getResultList();
				

				response.setList(lista);
				response.setStatus("OK");
				response.setMensaje("Consulta exitosa!!!!");
//				filtro.getClave();
//				
//				filtro.getNombre();
//				
		
		return response;
	}

}
