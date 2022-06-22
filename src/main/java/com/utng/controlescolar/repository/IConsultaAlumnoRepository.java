package com.utng.controlescolar.repository;


import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;

public interface IConsultaAlumnoRepository {
	Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro);

}
