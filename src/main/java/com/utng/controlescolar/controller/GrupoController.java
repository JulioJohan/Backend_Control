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
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.model.GrupoFiltroRequest;
import com.utng.controlescolar.model.GrupoRequest;
import com.utng.controlescolar.repository.Response;
import com.utng.controlescolar.sevice.IGrupoService;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

	@Autowired
	private IGrupoService grupoService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE) //CREA UNA RUTA Y CON PRODUCE NOS PRODUCE UN JSON
	
	
public ResponseEntity<Response<Grupo>> consultartodos(){
		
		Response<Grupo> response =grupoService.consultarTodos();
		
	
		
		return new ResponseEntity<Response<Grupo>> (response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarGrupo",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	
	public ResponseEntity<Response <Grupo>> guardarGrupo (@RequestBody GrupoRequest grupo){ //Requestbody es por que va a resivir
		
		Response<Grupo> response = grupoService.guardarGrupo(grupo);
		
		return new ResponseEntity<Response<Grupo>> (response, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/buscarGrupoPorID/{idGrupo}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> consultarGrupoPorID (@PathVariable("idGrupo") Integer idGrupo){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Grupo> response = grupoService.buscarGrupoId(idGrupo);
		
		return new ResponseEntity<Response<Grupo>> (response,HttpStatus.OK);
		
	}
	
	@DeleteMapping(path = "/borrarGrupoPorID/{idGrupo}", //esto hacee referencia a que solo uno //deletemapping es para eliminar
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarGrupoPorID (@PathVariable("idGrupo") Integer idGrupo){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Integer> response = grupoService.eliminarGrupo(idGrupo);
		
		return new ResponseEntity<Response<Integer>> (response ,HttpStatus.OK);
		
	}
	
	@PutMapping(path = "/actualizarGrupo",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response<Grupo>> actualizarGrupo(@RequestBody GrupoRequest grupo){ //Requestbody es por que va a resivir //como consume y produce un json se pone el consumes y procuces "CIclo ciclo"
		
		Response<Grupo> response = grupoService.actualizaGrupo(grupo);
		
		return new ResponseEntity<Response<Grupo>> (response, HttpStatus.OK);
		
	}

	
	@PostMapping(path = "/consultarPorNombreClave2",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response<Grupo>> consultaPorGrupo2 (@RequestBody GrupoFiltroRequest grupo){ //ciclo es una variable que contine ya el nombre y la clave provinientes del modelo
		
		Response<Grupo> response = grupoService.busquedaPorGrupo(grupo.getGrupo(), grupo.getId());//con cilo.getVariableAUsar() sacamos del modelo CicloRequest los valores necesarios 
		
		return new ResponseEntity<Response<Grupo>> (response, HttpStatus.OK);
		
	}
	

	
}
