package com.utng.controlescolar.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Response<T> implements Serializable { // esta clase servira para encapsular todos los objetos de todo tipo que yo regrese desd el controller
//<T> clase generica
	/**
	 * 
	 */
	private static final long serialVersionUID = 5001956122437201597L;
	
	@Getter @Setter
	private String status;
	
	@Getter @Setter
	private String mensaje;
	
	private transient List<T> list= null; //regresa un array list
	
	@Getter @Setter
	private int count =0;
	
	
	@Getter @Setter
	private T data; // lo que ingrese lo muestra aca 
	
	
	//getters y setters de una lista
	//get
	public List<T> getList() {
		List<T> tmp = null;
		if(this.list !=null) {
			tmp =new ArrayList<T>(this.list);
		}
		return tmp;
	}
	
	//set
	//resive un valor y se lo da a la lista
	public void setList(List<T> tmp) {
		if(tmp != null) {
			this.list = new ArrayList<T> (tmp);
		}		
	}
	
	
}

	
