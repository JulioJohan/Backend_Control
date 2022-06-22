package com.utng.controlescolar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TBL_ALUMNO")
public class Alumno implements Serializable{
	/*
	 * CREATE TABLE TBL_ALUMNO (
  ID_ALUMNO int(11) NOT NULL AUTO_INCREMENT,
  EXPEDIENTE varchar(20) DEFAULT NULL,
  NOMBRE varchar(60) DEFAULT NULL,
  CURP varchar(30) DEFAULT NULL,
  GENERO varchar(17) DEFAULT NULL,
  CORREO varchar(255) DEFAULT NULL,
  ESTATUS varchar(20) DEFAULT NULL,
  FOTO BLOB DEFAULT NULL,
  ID_CICLO int(11) DEFAULT NULL,
  PRIMARY KEY (ID_ALUMNO),
  FOREIGN KEY (ID_CICLO) REFERENCES TBL_CICLO_ESCOLAR(ID_CICLO)
) ;
	 */

	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Nos dice que este valor es autoincrementable
	@Column(name = "ID_ALUMNO")//HACE REFERENCIA A LAS COLUMNAS Y AGREGA EL DATO A LA TABLA
	private Integer id;
	
	@Column(name = "EXPEDIENTE")
	private String expediente;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CURP")
	private String curp;

	@Column(name = "GENERO")
	private String genero;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "ESTATUS")
	private String estatus;
	
	@ManyToOne(fetch= FetchType.EAGER)//FK
	@JoinColumn(name = "ID_CICLO")
	private Ciclo ciclo;

	
	
}

