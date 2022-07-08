package com.utng.controlescolar.sevice;


import java.util.Date;
import java.util.Set;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.Response;

public interface IDinamicoService {

	Response<Ciclo> findUserByEmails(Set<String> nombre , Set<String> clave);
	
}
