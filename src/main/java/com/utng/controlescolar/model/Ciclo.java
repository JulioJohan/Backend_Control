package com.utng.controlescolar.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TBL_CICLO_ESCOLAR")
public class Ciclo implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -1583460689462715838L;

/*
 * CREATE TABLE TBL_CICLO_ESCOLAR (
  ID_CICLO int(11) NOT NULL AUTO_INCREMENT, //MYSQL autoincrementa por defecto
  CLAVE varchar(12) DEFAULT NULL,
  NOMBRE varchar(30) DEFAULT NULL,
  ESTATUS int(11) DEFAULT NULL,
  PERIODO int(11) DEFAULT NULL,
  FECHA_INICIO date DEFAULT NULL,
  FECHA_FIN date DEFAULT NULL,
  PRIMARY KEY (ID_CICLO)
);

 */
	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Nos dice que este valor es autoincrementable
	@Column(name = "ID_CICLO")//HACE REFERENCIA A LAS COLUMNAS Y AGREGA EL DATO A LA TABLA
	private Integer id;
	
	@Column(name = "CLAVE")
	private String clave;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ESTATUS")
	private Integer estatus;
	
	@Column(name = "PERIODO")
	private Integer periodo;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;

	
	
}
