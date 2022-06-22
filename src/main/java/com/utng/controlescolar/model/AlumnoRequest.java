package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoRequest {
	private String expediente;

	private String nombre;

	private String curp;

	private String genero;
	
	private String correo;
	
	private String estatus;

	//El id 
	private Integer ciclo;

}
