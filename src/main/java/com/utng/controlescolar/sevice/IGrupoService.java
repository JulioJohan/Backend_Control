package com.utng.controlescolar.sevice;



import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.model.GrupoRequest;
import com.utng.controlescolar.repository.Response;

public interface IGrupoService {

	Response<Grupo> consultarTodos();
		
	Response<Grupo> guardarGrupo(GrupoRequest grupo);
	
	Response<Grupo> buscarGrupoId(Integer idGrupo);
	
	Response<Integer> eliminarGrupo (Integer idGrupo);
	
	Response<Grupo> actualizaGrupo (GrupoRequest grupo);
	
	Response<Grupo> busquedaPorGrupo(String grupo, Integer id);
	
}
