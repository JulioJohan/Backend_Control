package com.utng.controlescolar.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.AlumnoRequest;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.AlumnoRepository;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.repository.IConsultaAlumnoRepository;
import com.utng.controlescolar.repository.Response;

@Service
public class AlumnoService  implements IAlumnoService{

	@Autowired
	private IConsultaAlumnoRepository consultaAlumnoRepository;

	@Autowired
	private CicloRepository cicloRepository;

	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	
	@Override
	public Response<Alumno> consultarTodos() {
		Response<Alumno> response = new Response<Alumno>();
		List<Alumno> lista = alumnoRepository.findAll();
		response.setCount(lista.size());
		response.setList(lista);
		response.setStatus("OK");
		response.setMensaje("Consulta correcta :3");
		return response;
	}



	@Override
	public Response<Alumno> buscarAlumnoId(Integer idAlumno) {
		Response<Alumno> response = new Response<Alumno>();

		Alumno alumno = null;

		Optional<Alumno> optional = alumnoRepository.findById(idAlumno); // optional es una capsula para saber si regreso o
																		// no un registro

		if (optional.isPresent()) {

			alumno = optional.get();
			alumno = optional.get();
			response.setStatus("OK");
			response.setMensaje("Busqueda correcta :3");
			response.setData(alumno);

		} else {

			response.setMensaje("Sin resultados :c");
			response.setData(null);

		}

		return response;
	}


	@Override
	public Response<Integer> eliminarAlumno(Integer idAlumno) {
		Response<Integer> response = new Response<Integer>();

		alumnoRepository.deleteById(idAlumno);

		response.setMensaje("Eliminado correctamente :3");
		response.setStatus("OK");
		response.setData(idAlumno);

		return response;
	}


	@Override
	public Response<Alumno> actualizarAlumno(Alumno alumno) {
		Response<Alumno> response = new Response<Alumno>();
		
		Alumno alumnoAct = alumnoRepository.save(alumno);
		response.setStatus("ERROR");
		response.setMensaje("Ciclo no existente :c");
		response.setData(alumnoAct);
//		Optional<Alumno> idAlumno = cicloRepository.findById(alumno.getId());
//		Optional <Ciclo> optionalCiclo = cicloRepository.findById(alumno.getCiclo());
//		Ciclo ciclo = null;
//		Alumno alumno1 = null;
//		Alumno alumno2 = null;
//		
//		
//		if (optionalCiclo.isPresent()) {
//
//			ciclo = optionalCiclo.get();
//			alumno1 = new Alumno();
//			alumno1.setId(alumno.getId());
//			alumno1.setExpediente(alumno.getExpediente()); //convertir el objeto MateriaRequest en Materia
//			alumno1.setCiclo(ciclo);
//			alumno1.setNombre(alumno.getNombre());
//			alumno1.setCurp(alumno.getCurp());
//			alumno1.setGenero(alumno.getGenero());
//			alumno1.setCorreo(alumno.getCorreo());
//			alumno1.setEstatus(alumno.getEstatus());
//			
//			alumno2 = alumnoRepository.save(alumno1);
//			response.setStatus("OK");
//			response.setMensaje("Guardado correcto :3");
//			response.setData(alumno2);
//
//		} else {
//			
//			response.setStatus("ERROR");
//			response.setMensaje("Ciclo no existente :c");
//			response.setData(null);
//
//		}

		return response;
	}


	@Override
	public Response<Alumno> guardarAlumno(Alumno alumno) {
		Response<Alumno> response = new Response<Alumno>();

		Alumno alumnoNuevo = alumnoRepository.save(alumno);
		response.setStatus("ERROR");
		response.setMensaje("Ciclo no existente :c");
		response.setData(alumnoNuevo);
		
//		Optional <Ciclo> optionalCiclo = cicloRepository.findById(alumno.getCiclo());
//		Ciclo ciclo = null;
//		Alumno alumno1 = null;
//		Alumno alumno2 = null;
//		
//		if (optionalCiclo.isPresent()) {
//
//			ciclo = optionalCiclo.get();
//			alumno1 = new Alumno();
//			alumno1.setExpediente(alumno.getExpediente()); //convertir el objeto MateriaRequest en Materia
//			alumno1.setCiclo(ciclo);
//			alumno1.setNombre(alumno.getNombre());
//			alumno1.setCurp(alumno.getCurp());
//			alumno1.setGenero(alumno.getGenero());
//			alumno1.setCorreo(alumno.getCorreo());
//			alumno1.setEstatus(alumno.getEstatus());
//			
//			alumno2 = alumnoRepository.save(alumno1);
//			response.setStatus("OK");
//			response.setMensaje("Guardado correcto :3");
//			response.setData(alumno2);
//
//		} else {
//			
//			response.setStatus("ERROR");
//			response.setMensaje("Ciclo no existente :c");
//			response.setData(null);
//
//		}

		return response;
	}



	@Override
	public Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro) {
		Response<Alumno> response = new Response<Alumno>();
		response = consultaAlumnoRepository.busquedaAlumno(filtro);
		return response;
	}

}



