package com.utng.controlescolar.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.AlumnoGrupo;

import com.utng.controlescolar.repository.AlumnoGrupoRepository;

@Service
public class AlumnoGrupoService implements IAlumnoGrupoService{

	@Autowired
	private AlumnoGrupoRepository alumnoGrupoRepository;
	
	@Override
	public List<AlumnoGrupo> consultarTodos() {
		
		return alumnoGrupoRepository.findAll();
	}

}
