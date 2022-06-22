package com.utng.controlescolar.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.model.GrupoRequest;
import com.utng.controlescolar.repository.GrupoRepository;
import com.utng.controlescolar.repository.Response;

@Service
public class GrupoService implements IGrupoService{

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CicloRepository cicloRepository;
	
	@Override
	public Response<Grupo> consultarTodos() {
		
		Response<Grupo> response = new Response<Grupo>();
		
		List<Grupo> lista = grupoRepository.findAll();
		
		response.setCount(lista.size());
		response.setList(lista);
		response.setStatus("OK");
		response.setMensaje("Consulta correcta :3");

		return response;

}

@Override
public Response<Grupo> guardarGrupo(GrupoRequest grupo) {

	Response<Grupo> response = new Response<Grupo>();

	Optional <Ciclo> optionalCiclo = cicloRepository.findById(grupo.getCiclo());
	
	Ciclo ciclo = null;
	Grupo grupo1 = null;
	Grupo grupo2 = null;
	
	if (optionalCiclo.isPresent()) {

		ciclo = optionalCiclo.get();
		grupo1 = new Grupo();
		grupo1.setCiclo(ciclo);
		grupo1.setEstatus(grupo.getEstatus());//convertir el objeto MateriaRequest en Materia
		grupo1.setGrupo(grupo.getGrupo());
		grupo2 = grupoRepository.save(grupo1);
		response.setStatus("OK");
		response.setMensaje("Guardado correcto :3");
		response.setData(grupo2);

	} else {
		
		response.setStatus("ERROR");
		response.setMensaje("Ciclo no existente :c");
		response.setData(null);

	}


	return response;

}

@Override
public Response<Grupo> buscarGrupoId(Integer idGrupo) {

	Response<Grupo> response = new Response<Grupo>();

	Grupo grupo = null;

	Optional<Grupo> optional = grupoRepository.findById(idGrupo); // optional es una capsula para saber si regreso o
																	// no un registro

	if (optional.isPresent()) {

		grupo = optional.get();
		grupo = optional.get();
		response.setStatus("OK");
		response.setMensaje("Busqueda correcta :3");
		response.setData(grupo);

	} else {

		response.setMensaje("Sin resultados :c");
		response.setData(null);

	}

	return response;

}

@Override
public Response<Integer> eliminarGrupo(Integer idGrupo) {

	Response<Integer> response = new Response<Integer>();

	grupoRepository.deleteById(idGrupo);

	response.setMensaje("Eliminado correctamente :3");
	response.setStatus("OK");
	response.setData(idGrupo);

	return response;
}

@Override
public Response<Grupo> actualizaGrupo(GrupoRequest grupo) {
	
	Response<Grupo> response = new Response<Grupo>();
	
	Optional <Ciclo> optionalCiclo = cicloRepository.findById(grupo.getCiclo());
	
	Ciclo ciclo = null;
	Grupo grupo1 = null;
	Grupo grupo2 = null;
	
	if (optionalCiclo.isPresent()) {

		ciclo = optionalCiclo.get();
		grupo1 = new Grupo();
		grupo1.setCiclo(ciclo);
		grupo1.setEstatus(grupo.getEstatus());//convertir el objeto MateriaRequest en Materia
		grupo1.setGrupo(grupo.getGrupo());
		grupo2 = grupoRepository.save(grupo1);
		response.setStatus("OK");
		response.setMensaje("Guardado correcto :3");
		response.setData(grupo2);

	} else {
		
		response.setStatus("ERROR");
		response.setMensaje("Ciclo no existente :c");
		response.setData(null);

	}


	return response;
}

@Override
public Response<Grupo> busquedaPorGrupo(String grupo, Integer id) {

	Response<Grupo> response = new Response<Grupo>();

	Grupo grupo1 = null;

	Optional<Grupo> optional = grupoRepository.consultarPorNombre(grupo, id); // optional es una capsula para
																					// saber si regreso o no un
																					// registro

	if (optional.isPresent()) {

		grupo1 = optional.get();
		response.setStatus("OK");
		response.setMensaje("Busqueda correcta :3");
		response.setData(grupo1);

	} else {

		response.setMensaje("Sin resultados :c");
		response.setData(null);

	}

	return response;
}

}

