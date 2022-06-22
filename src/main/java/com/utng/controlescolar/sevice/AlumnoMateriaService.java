package com.utng.controlescolar.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.AlumnoMateria;
import com.utng.controlescolar.repository.AlumnoMateriaRepository;

@Service
public class AlumnoMateriaService implements IAlumnoMateriaService {

	@Autowired
	private AlumnoMateriaRepository alumnoMateriaRepository;
	
	@Override
	public List<AlumnoMateria> consultarTodos() {
		
		return alumnoMateriaRepository.findAll();
	}

	
}
