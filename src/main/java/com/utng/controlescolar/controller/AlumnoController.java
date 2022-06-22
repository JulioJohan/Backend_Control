package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.AlumnoRequest;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaRequest;
import com.utng.controlescolar.repository.Response;
import com.utng.controlescolar.sevice.IAlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> consultartodos(){
		
		Response<Alumno> lista = alumnoService.consultarTodos();
		
		return new ResponseEntity<Response<Alumno>> (lista, HttpStatus.OK);
		
	}
	@PostMapping(path = "/guardarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response <Alumno>> guardarAlumno (@RequestBody AlumnoRequest materia){ //Requestbody es por que va a resivir
		
		//guardamos lo que mando objeto lo mque mando el usuario
		Response<Alumno> response = alumnoService.guardarAlumno(materia);
		
		return new ResponseEntity<Response<Alumno>> (response, HttpStatus.OK);
		
	}
	@DeleteMapping(path = "/borrarAlumnoID/{idAlumno}", //esto hacee referencia a que solo uno //deletemapping es para eliminar
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarCicloPorID (@PathVariable("idAlumno") Integer idAlumno){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		Response<Integer> response = alumnoService.eliminarAlumno(idAlumno);
		
		return new ResponseEntity<Response<Integer>> (response ,HttpStatus.OK);
		
	}
	
	@PutMapping(path = "/actualizarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response<Alumno>> actualizarAlumno (@RequestBody AlumnoRequest alumno){ //Requestbody es por que va a resivir //como consume y produce un json se pone el consumes y procuces "CIclo ciclo"
		
		Response<Alumno> response = alumnoService.actualizarAlumno(alumno);
		
		return new ResponseEntity<Response<Alumno>> (response, HttpStatus.OK);
		
	}
	@GetMapping(path = "/buscarAlumnoId/{idAlumno}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> consultarMateriaPorID (@PathVariable("idAlumno") Integer idAlumno){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Alumno> response = alumnoService.buscarAlumnoId(idAlumno);
		
		return new ResponseEntity<Response<Alumno>> (response,HttpStatus.OK);
		
	}
	@PostMapping(path = "/busquedaAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response <Alumno>> busquedaAlumno (@RequestBody AlumnoFiltroRequest alumno){ //Requestbody es por que va a resivir
		
		//guardamos lo que mando objeto lo mque mando el usuario
		Response<Alumno> response = alumnoService.busquedaAlumno(alumno);
		
		return new ResponseEntity<Response<Alumno>> (response, HttpStatus.OK);
		
	}
	
	
	

	
}
