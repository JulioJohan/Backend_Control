package com.utng.controlescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.AlumnoGrupo;

import com.utng.controlescolar.sevice.IAlumnoGrupoService;

@RestController
@RequestMapping("/alumnoGrupo")
public class AlumnoGrupoController {

	@Autowired
	private IAlumnoGrupoService alumnoGrupoService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE) //CREA UNA RUTA Y CON PRODUCE NOS PRODUCE UN JSON
	public ResponseEntity<List<AlumnoGrupo>> consultartodos(){
		
		List<AlumnoGrupo> lista = alumnoGrupoService.consultarTodos();
		
		return new ResponseEntity<List<AlumnoGrupo>> (lista, HttpStatus.OK);
		
	}
}
