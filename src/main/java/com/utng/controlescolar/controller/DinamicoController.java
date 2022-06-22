package com.utng.controlescolar.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.Response;
//import com.utng.controlescolar.repository.Response;
import com.utng.controlescolar.sevice.IDinamicoService;

@RestController
@RequestMapping("/dinamico")
public class DinamicoController {

	@Autowired
	private IDinamicoService dinamicoService;
	
	@GetMapping(path = "/buscarCicloDinamico/{nombre}/{clave}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Ciclo> consultarCicloPorID (@PathVariable("nombre") Set<String> nombre , @PathVariable("clave")Set<String> clave){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Ciclo> lista = dinamicoService.findUserByEmails(nombre, clave);
		
		return lista;
		
	}
	
}
