package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;
import com.utng.controlescolar.model.MateriaRequest;
import com.utng.controlescolar.repository.Response;
import com.utng.controlescolar.sevice.IMateriaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE) //CREA UNA RUTA Y CON PRODUCE NOS PRODUCE UN JSON
public ResponseEntity<Response<Materia>> consultartodos(){
		
		Response<Materia> response = materiaService.consultarTodos();
		
	
		
		return new ResponseEntity<Response<Materia>> (response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarMateria",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response <Materia>> guardarMateria (@RequestBody MateriaRequest materia){ //Requestbody es por que va a resivir
		
		//guardamos lo que mando objeto lo mque mando el usuario
		Response<Materia> response = materiaService.guardarMateria(materia);
		
		return new ResponseEntity<Response<Materia>> (response, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/buscarMateriaPorID/{idMateria}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> consultarMateriaPorID (@PathVariable("idMateria") Integer idMateria){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Materia> response = materiaService.buscarMateriaId(idMateria);
		
		return new ResponseEntity<Response<Materia>> (response,HttpStatus.OK);
		
	}
	
	@DeleteMapping(path = "/borrarMateriaPorID/{idMateria}", //esto hacee referencia a que solo uno //deletemapping es para eliminar
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarCicloPorID (@PathVariable("idMateria") Integer idMateria){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Integer> response = materiaService.eliminarMateria(idMateria);
		
		return new ResponseEntity<Response<Integer>> (response ,HttpStatus.OK);
		
	}
	
	@PutMapping(path = "/actualizarMateria",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response<Materia>> actualizarMateria (@RequestBody MateriaRequest materia){ //Requestbody es por que va a resivir //como consume y produce un json se pone el consumes y procuces "CIclo ciclo"
		
		Response<Materia> response = materiaService.actualizaMateria(materia);
		
		return new ResponseEntity<Response<Materia>> (response, HttpStatus.OK);
		
	}

	
	@PostMapping(path = "/consultarPorNombreClave2",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response<Materia>> consultaPorNombre2 (@RequestBody MateriaFiltroRequest materia){ //ciclo es una variable que contine ya el nombre y la clave provinientes del modelo
		
		Response<Materia> response = materiaService.busquedaPorNombreClave(materia.getNombre(), materia.getClave());//con cilo.getVariableAUsar() sacamos del modelo CicloRequest los valores necesarios 
		
		return new ResponseEntity<Response<Materia>> (response, HttpStatus.OK);
		
	}
	@PostMapping(path = "/busquedafiltros", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir un objetp
	public ResponseEntity<Response<Materia>> busquedaPorFiltro (@RequestBody MateriaFiltroRequest materia){ //ciclo es una variable que contine ya el nombre y la clave provinientes del modelo
		
		Response<Materia> response = materiaService.busquedaMateria(materia);//con cilo.getVariableAUsar() sacamos del modelo CicloRequest los valores necesarios 
		
		return new ResponseEntity<Response<Materia>> (response, HttpStatus.OK);
		
	}

}
