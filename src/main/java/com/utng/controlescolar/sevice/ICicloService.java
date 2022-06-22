package com.utng.controlescolar.sevice;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.Response;

public interface ICicloService {
	
	Response<Ciclo> consultarTodos();
	
	Response<Ciclo> guardarCiclo(Ciclo ciclo);
	
	Response<Ciclo> buscarCicloId(Integer idCiclo);
	
	Response<Integer> eliminarCiclo (Integer idCiclo);
	
	Response<Ciclo> actualizaCiclo (Ciclo ciclo);
	
	Response<Ciclo> busquedaPorNombreClave(String nombre, String clave);
	
	 Response<Ciclo> buscarNombreOClave(String nombre, String clave);
	
}
