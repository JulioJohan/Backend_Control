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
@Table(name = "TBL_ALUMNO_MATERIAS")
public class AlumnoMateria {
	/*
	 * 
CREATE TABLE TBL_ALUMNO_MATERIAS (
  ID_AL_MT int(11) NOT NULL AUTO_INCREMENT,
  EXPEDIENTE varchar(20) DEFAULT NULL,
  ID_MATERIA int(11) NOT NULL,
  PROMEDIO DECIMAL(2,2) DEFAULT NULL,
  ID_ALUMNO int(11) DEFAULT NULL,
  PRIMARY KEY (ID_AL_MT),
  FOREIGN KEY (ID_ALUMNO) REFERENCES TBL_ALUMNO(ID_ALUMNO),
  FOREIGN KEY (ID_MATERIA) REFERENCES TBL_MATERIAS(ID_MATERIA)  
);
	 */
	
	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Nos dice que este valor es autoincrementable
	@Column(name = "ID_AL_MT")//HACE REFERENCIA A LAS COLUMNAS Y AGREGA EL DATO A LA TABLA
	private Integer id;
	
	@Column(name = "EXPEDIENTE")
	private String expediente;
	
	@Column(name = "ID_MATERIA")
	private Integer materia;
	
	@Column(name = "PROMEDIO")
	private Integer promeio;

	@Column(name = "ID_ALUMNO")
	private Integer alumno;
}
