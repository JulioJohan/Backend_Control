package com.utng.controlescolar.sevice;


import java.util.Date;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.DinamicoImplRepository;
import com.utng.controlescolar.repository.Response;

@Service
public class DinamicoService implements IDinamicoService {

	@Autowired
	private DinamicoImplRepository dinamicoImplRepository;

	
	@Override
	public Response<Ciclo> findUserByEmails(Set<String> nombre, Set<String> clave) {
			
		Response<Ciclo> lista = dinamicoImplRepository.findUserByEmails(nombre, clave);	
		return lista;
	}

	
	
}
