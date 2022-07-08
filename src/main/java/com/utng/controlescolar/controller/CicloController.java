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
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.CicloFiltroRequest;
import com.utng.controlescolar.repository.Response;
import com.utng.controlescolar.sevice.ICicloService;



//Desde cualquier lado la podemos consumir
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ciclo")
public class CicloController {
	
	//creando objeto de la clase servise para obtener los metodos 
	@Autowired
	private ICicloService cicloService;
	

	//poniendo ruta para el controller 
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE) //CREA UNA RUTA Y CON PRODUCE NOS PRODUCE UN JSON
	public ResponseEntity<Response<Ciclo>> consultartodos(){
		
		
		//Creando una varibable de tipo lista grupo 
		//gruposervice y ponemos el metodo que pusimos en la interfaz
		Response<Ciclo> response =cicloService.consultarTodos();
		
	
		
		return new ResponseEntity<Response<Ciclo>> (response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarCiclo",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response <Ciclo>> guardarCiclo (@RequestBody Ciclo ciclo){ //Requestbody es por que va a resivir
		
		Response<Ciclo> response = cicloService.guardarCiclo(ciclo);
		
		return new ResponseEntity<Response<Ciclo>> (response, HttpStatus.OK);
		
	}
	//poniendo el id grupo porque se requiere un id para eliminar
	@GetMapping(path = "/buscarCicloPorID/{idCiclo}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarCicloPorID (@PathVariable("idCiclo") Integer idCiclo){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		//Creando objeto para guardar el metodo y llamarlo
		Response<Ciclo> response = cicloService.buscarCicloId(idCiclo);
		
		return new ResponseEntity<Response<Ciclo>> (response,HttpStatus.OK);
		
	}
	
	@DeleteMapping(path = "/borrarCicloPorID/{idCiclo}", //esto hacee referencia a que solo uno //deletemapping es para eliminar
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarCicloPorID (@PathVariable("idCiclo") Integer idCiclo){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Integer> response = cicloService.eliminarCiclo(idCiclo);
		
		return new ResponseEntity<Response<Integer>> (response ,HttpStatus.OK);
		
	}
	
	@PutMapping(path = "/actualizarCiclo",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
	public ResponseEntity<Response<Ciclo>> actualizarCiclo (@RequestBody Ciclo ciclo ){ //Requestbody es por que va a resivir //como consume y produce un json se pone el consumes y procuces "CIclo ciclo"
		
		Response<Ciclo> response = cicloService.actualizaCiclo(ciclo);
		
		return new ResponseEntity<Response<Ciclo>> (response,HttpStatus.OK);
		
	}
	@GetMapping(path = "/consultarPorNombreClave/{nombre}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarPorNombreClave (@PathVariable("nombre") String nombre, @PathVariable("clave") String clave
){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Ciclo> response = cicloService.busquedaPorNombreClave(nombre, clave);
		
		return new ResponseEntity<Response<Ciclo>> (response,HttpStatus.OK);
		
	}
	@PostMapping(path = "/buscarCiclo", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
			
	public ResponseEntity<Response<Ciclo>> buscarCiclo (
			@RequestBody CicloFiltroRequest filtro){
				
				Response<Ciclo> response = cicloService.buscarCiclo(filtro);
				
				return new ResponseEntity<Response<Ciclo>>(response,HttpStatus.OK);
			
	}
	

	
//	@PostMapping(path = "/consultarPorNombreClave2",
//			produces = MediaType.APPLICATION_JSON_VALUE, 
//			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a resivir
//	public ResponseEntity<Response<Ciclo>> consultaPorNombre2 (@RequestBody CicloRequest ciclo){ //ciclo es objeto que contine ya el nombre y la clave provinientes del modelo
//		
//		Response<Ciclo> response = cicloService.busquedaPorNombreClave(ciclo.getNombre(), ciclo.getClave());//con cilo.getVariableAUsar() sacamos del modelo CicloRequest los valores necesarios 
//		
//		return new ResponseEntity<Response<Ciclo>> (response, HttpStatus.OK);
//		
//	}
	
	

	
}


