package com.utng.controlescolar.model;

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
@Table(name = "TBL_GRUPO")
public class Grupo {

	/*
	 * CREATE TABLE TBL_GRUPO (
  ID_GRUPO int(11) NOT NULL AUTO_INCREMENT,
  GRUPO varchar(50) DEFAULT NULL,
  ESTATUS int(11) DEFAULT NULL,
  ID_CICLO int(11) DEFAULT NULL,
  PRIMARY KEY (ID_GRUPO),
  FOREIGN KEY (ID_CICLO) REFERENCES TBL_CICLO_ESCOLAR(ID_CICLO)
);

	 */
	
	
	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Nos dice que este valor es autoincrementable
	@Column(name = "ID_GRUPO")//HACE REFERENCIA A LAS COLUMNAS Y AGREGA EL DATO A LA TABLA
	private Integer id;
	
	@Column(name = "GRUPO")
	private String grupo;

	@Column(name = "ESTATUS")
	private String estatus;
	
	@ManyToOne(fetch= FetchType.EAGER)//FK
	@JoinColumn(name = "ID_CICLO")
	private Ciclo ciclo;


	
}
