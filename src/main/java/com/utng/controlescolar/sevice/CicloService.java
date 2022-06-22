package com.utng.controlescolar.sevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.repository.Response;

//los servicios mandan llamar repositorios

@Service
public class CicloService implements ICicloService {

	@Autowired
	private CicloRepository cicloRepository;

	@Override
	public Response<Ciclo> consultarTodos() {

		Response<Ciclo> response = new Response<Ciclo>();

		List<Ciclo> lista = cicloRepository.findAll();

		response.setCount(lista.size());
		response.setList(lista);
		response.setStatus("OK");
		response.setMensaje("Consulta correcta :3");

		return response;

	}

	@Override
	public Response<Ciclo> guardarCiclo(Ciclo ciclo) {

		Response<Ciclo> response = new Response<Ciclo>();

		Ciclo cicloNuevo = cicloRepository.save(ciclo);

		response.setStatus("OK");
		response.setMensaje("Guardado correcto :3");
		response.setData(cicloNuevo);

		return response;

	}

	@Override
	public Response<Ciclo> buscarCicloId(Integer idCiclo) {

		Response<Ciclo> response = new Response<Ciclo>();

		Ciclo ciclo = null;

		Optional<Ciclo> optional = cicloRepository.findById(idCiclo); // optional es una capsula para saber si regreso o
																		// no un registro

		if (optional.isPresent()) {

			ciclo = optional.get();
			ciclo = optional.get();
			response.setStatus("OK");
			response.setMensaje("Busqueda correcta :3");
			response.setData(ciclo);

		} else {

			response.setMensaje("Sin resultados :c");
			response.setData(null);

		}

		return response;

	}

	@Override
	public Response<Integer> eliminarCiclo(Integer idCiclo) {

		Response<Integer> response = new Response<Integer>();

		cicloRepository.deleteById(idCiclo);

		response.setMensaje("Eliminado correctamente :3");
		response.setStatus("OK");
		response.setData(idCiclo);

		return response;
	}

	@Override
	public Response<Ciclo> actualizaCiclo(Ciclo ciclo) {
		
		Response<Ciclo> response = new Response<Ciclo>();
		
		Ciclo cicloNuevo = cicloRepository.save(ciclo);
		
		 response.setMensaje("Actualizado correctamente :3");
		 response.setStatus("OK");
		 response.setData(cicloNuevo);
		
		return response;
	}

	@Override
	public Response<Ciclo> busquedaPorNombreClave(String nombre, String clave) {

		Response<Ciclo> response = new Response<Ciclo>();

		Ciclo ciclo = null;

		Optional<Ciclo> optional = cicloRepository.consultarPorNombre(nombre, clave); // optional es una capsula para
																						// saber si regreso o no un
																						// registro

		if (optional.isPresent()) {

			ciclo = optional.get();
			response.setStatus("OK");
			response.setMensaje("Busqueda correcta :3");
			response.setData(ciclo);

		} else {

			response.setMensaje("Sin resultados :c");
			response.setData(null);

		}

		return response;
	}
	

	@Override
	public Response<Ciclo> buscarNombreOClave(String nombre, String clave) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 /*public Response<Ciclo> buscarNombreOClave(String nombre, String clave) {
		EntityManagerFactory enitityManager = Persistence.createEntityManagerFactory("cap_control_escolar");
		CriteriaBuilder cb = enitityManager.getCriteriaBuilder();
	    CriteriaQuery<Ciclo> query = cb.createQuery(Ciclo.class);
	    Root<Ciclo> root = query.from(Ciclo.class);

	   Response<Predicate> predicates = new ArrayList<>();
	    predicates.add(cb.equal(root.get(Ciclo_.NOMBRE), nombre));
	    predicates.add(cb.equal(root.get(Ciclo_.CLAVE), clave));

	    if(nombre != null) {
	        predicates.add(cb.equal(root.get(Ciclo_.NOMBRE, nombre));
	    }

	    query.select(root).where(cb.and(ciclo.toArray(new Ciclo[0])));
																		
	    return entityManager.createQuery(query).getResultList();
	}*/

}
