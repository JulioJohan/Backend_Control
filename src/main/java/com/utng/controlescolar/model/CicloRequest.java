package com.utng.controlescolar.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CicloRequest {

	private String clave;
	private String nombre;

}
