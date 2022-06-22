package com.utng.controlescolar.repository;

import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;

public interface IConsultaMateriaRepository {

	Response<Materia> busquedaMateria(MateriaFiltroRequest filtro);
	
}
