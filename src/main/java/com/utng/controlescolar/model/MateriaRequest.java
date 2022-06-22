package com.utng.controlescolar.model;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaRequest {
		
	private String clave;

	private String nombre;

	private Integer estatus;

	//El id 
	private Integer ciclo;

}
