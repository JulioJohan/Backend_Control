package com.utng.controlescolar.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;
import com.utng.controlescolar.model.MateriaRequest;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.repository.IConsultaAlumnoRepository;
import com.utng.controlescolar.repository.IConsultaMateriaRepository;
import com.utng.controlescolar.repository.MateriaRepository;
import com.utng.controlescolar.repository.Response;

@Service
public class MateriaService implements IMateriaService {

	@Autowired
	private IConsultaMateriaRepository consultaMateriaRepository;
	
	@Autowired //inyecta dependencias //mando llamar el repository del contexto con Autowired
	private MateriaRepository materiaRepository; //el repository ya vive en el contexto
	@Autowired
	//Podemos agregar tanto respositorios de lo que ocupamos
	private CicloRepository cicloRepository;
	
	@Override
	public Response<Materia> consultarTodos() {

		Response<Materia> response = new Response<Materia>();

		List<Materia> lista = materiaRepository.findAll();

		response.setCount(lista.size());
		response.setList(lista);
		response.setStatus("OK");
		response.setMensaje("Consulta correcta :3");

		return response;

	}

	@Override
	public Response<Materia> guardarMateria(MateriaRequest materia) {

		Response<Materia> response = new Response<Materia>();

		Optional <Ciclo> optionalCiclo = cicloRepository.findById(materia.getCiclo());
		Ciclo ciclo = null;
		Materia materia1 = null;
		Materia materia2 = null;
		
		if (optionalCiclo.isPresent()) {

			ciclo = optionalCiclo.get();
			materia1 = new Materia();
			materia1.setClave(materia.getClave()); //convertir el objeto MateriaRequest en Materia
			materia1.setCiclo(ciclo);
			materia1.setEstatus(materia.getEstatus());
			materia1.setNombre(materia.getNombre());
			materia2 = materiaRepository.save(materia1);
			response.setStatus("OK");
			response.setMensaje("Guardado correcto :3");
			response.setData(materia2);

		} else {
			
			response.setStatus("ERROR");
			response.setMensaje("Ciclo no existente :c");
			response.setData(null);

		}


		return response;

	}

	@Override
	public Response<Materia> buscarMateriaId(Integer idMateria) {

		Response<Materia> response = new Response<Materia>();

		Materia materia = null;

		Optional<Materia> optional = materiaRepository.findById(idMateria); // optional es una capsula para saber si regreso o
																		// no un registro

		if (optional.isPresent()) {

			materia = optional.get();
			materia = optional.get();
			response.setStatus("OK");
			response.setMensaje("Busqueda correcta :3");
			response.setData(materia);

		} else {

			response.setMensaje("Sin resultados :c");
			response.setData(null);

		}

		return response;

	}

	@Override
	public Response<Integer> eliminarMateria(Integer idMateria) {

		Response<Integer> response = new Response<Integer>();

		materiaRepository.deleteById(idMateria);

		response.setMensaje("Eliminado correctamente :3");
		response.setStatus("OK");
		response.setData(idMateria);

		return response;
	}

	@Override
	public Response<Materia> actualizaMateria(MateriaRequest materia) {
		
		Response<Materia> response = new Response<Materia>();
		
		Optional <Ciclo> optionalCiclo = cicloRepository.findById(materia.getCiclo());
		Ciclo ciclo = null;
		Materia materia1 = null;
		Materia materia2 = null;
		
		if (optionalCiclo.isPresent()) {

			ciclo = optionalCiclo.get();
			materia1 = new Materia();
			materia1.setClave(materia.getClave()); //convertir el objeto MateriaRequest en Materia
			materia1.setCiclo(ciclo);
			materia1.setEstatus(materia.getEstatus());
			materia1.setNombre(materia.getNombre());
			materia2 = materiaRepository.save(materia1);
			response.setStatus("OK");
			response.setMensaje("Guardado correcto :3");
			response.setData(materia2);

		} else {
			
			response.setStatus("ERROR");
			response.setMensaje("Ciclo no existente :c");
			response.setData(null);

		}


		return response;
	}

	@Override
	public Response<Materia> busquedaPorNombreClave(String nombre, String clave) {

		Response<Materia> response = new Response<Materia>();

		Materia materia = null;

		Optional<Materia> optional = materiaRepository.consultarPorNombreClave(nombre, clave); // optional es una capsula para
																						// saber si regreso o no un
																						// registro

		if (optional.isPresent()) {

			materia = optional.get();
			response.setStatus("OK");
			response.setMensaje("Busqueda correcta :3");
			response.setData(materia);

		} else {

			response.setMensaje("Sin resultados :c");
			response.setData(null);

		}

		return response;
	}

	@Override
	public Response<Materia> busquedaMateria(MateriaFiltroRequest filtro) {
		Response<Materia> response = new Response<Materia>();
		
		response = consultaMateriaRepository.busquedaMateria(filtro);
		return response;
	}
	


}
