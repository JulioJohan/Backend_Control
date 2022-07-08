package com.utng.controlescolar.sevice;



import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.AlumnoRequest;
import com.utng.controlescolar.repository.Response;

public interface IAlumnoService {

	Response<Alumno> consultarTodos();
	Response<Alumno> guardarAlumno(Alumno materia);

	Response<Alumno> buscarAlumnoId(Integer idAlumno);
	
	Response<Integer> eliminarAlumno (Integer idAlumno);
	
	Response<Alumno> actualizarAlumno (Alumno alumno);
	Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro);

}

