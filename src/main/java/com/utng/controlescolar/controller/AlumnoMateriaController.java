package com.utng.controlescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.AlumnoMateria;

import com.utng.controlescolar.sevice.IAlumnoMateriaService;

@RestController
@RequestMapping("/alumnoMateria")
public class AlumnoMateriaController {

	@Autowired
	private IAlumnoMateriaService alumnoMateriaService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE) //CREA UNA RUTA Y CON PRODUCE NOS PRODUCE UN JSON
	public ResponseEntity<List<AlumnoMateria>> consultartodos(){
		
		List<AlumnoMateria> lista = alumnoMateriaService.consultarTodos();
		
		return new ResponseEntity<List<AlumnoMateria>> (lista, HttpStatus.OK);
		
	}
}
