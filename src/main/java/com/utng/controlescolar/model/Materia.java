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
@Table(name = "TBL_MATERIAS") //llamamos la tabla de la base de datos
public class Materia implements Serializable{
	
/*
 * CREATE TABLE TBL_MATERIAS (
  ID_MATERIA int(11) NOT NULL AUTO_INCREMENT,
  CLAVE varchar(12) DEFAULT NULL,
  NOMBRE varchar(30) DEFAULT NULL,
  ESTATUS int(11) DEFAULT NULL,
  ID_CICLO int(11) DEFAULT NULL,
  PRIMARY KEY (ID_MATERIA),
  FOREIGN KEY (ID_CICLO) REFERENCES TBL_CICLO_ESCOLAR(ID_CICLO)
);
 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6294468319997277393L;

	@Id//la llave primaria es la que este debajo de esto
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrementable
	@Column(name = "ID_MATERIA")//hace referencia a las columnas para asignar el dato
	private Integer id;
	
	@Column(name = "CLAVE")
	private String clave;
	
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ESTATUS")
	private Integer estatus;
	
	@ManyToOne(fetch= FetchType.EAGER)//FK
	@JoinColumn(name = "ID_CICLO")
	private Ciclo ciclo;



}
