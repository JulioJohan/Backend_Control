package com.utng.controlescolar.model;

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
//Llamando el nombre de la tabla
@Table(name = "TBL_GRUPO_ALUMNO")
public class AlumnoGrupo {
	
	/*
	 * CREATE TABLE TBL_GRUPO_ALUMNO (
	ID_GR_AL int(11) NOT NULL AUTO_INCREMENT,
	ID_GRUPO int(11) NOT NULL,
	ID_ALUMNO int(11) NOT NULL,
	PRIMARY KEY (ID_GR_AL),
	FOREIGN KEY (ID_ALUMNO) REFERENCES TBL_ALUMNO(ID_ALUMNO),
	FOREIGN KEY (ID_GRUPO) REFERENCES TBL_GRUPO(ID_GRUPO)
	
);	
	 */
	
	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Nos dice que este valor es autoincrementable
	@Column(name = "ID_GR_AL")//HACE REFERENCIA A LAS COLUMNAS Y AGREGA EL DATO A LA TABLA
	private Integer id;
	

	@Column(name = "ID_GRUPO")
	private String grupo;
	
	@Column(name = "ID_ALUMNO")
	private Integer alumno;
	

}
