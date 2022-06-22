package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoFiltroRequest {
	private String expediente;
	private String curp;
	private String correo;
}
