package com.utng.controlescolar.sevice;

import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;
import com.utng.controlescolar.model.MateriaRequest;
import com.utng.controlescolar.repository.Response;

//las interfaces son plantillas que guardan ls operciones/comportamientos/atributos basicos para despues heredarlas
public interface IMateriaService {
	
	Response<Materia> consultarTodos();
	
	Response<Materia> guardarMateria(MateriaRequest materia);
	
	Response<Materia> buscarMateriaId(Integer idMateria);
	
	Response<Integer> eliminarMateria(Integer idMateria);
	
	Response<Materia> actualizaMateria (MateriaRequest materia);
	
	Response<Materia> busquedaPorNombreClave(String nombre, String clave);
	
	Response<Materia> busquedaMateria(MateriaFiltroRequest filtro);

	
}
