package com.examen.ricardo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.ricardo.entities.Trabajo;
import com.examen.ricardo.exceptions.ServiceException;
import com.examen.ricardo.repositories.TrabajoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrabajoServicio implements ITrabajoServicio{

	@Autowired
	TrabajoRepository repository;
	
	public void crearTrabajo(Trabajo trabajo) throws ServiceException{
		try {
			log.info("[crearTrabajo]");
			log.debug("[crearTrabajo: "+trabajo.toString()+"]");
			repository.save(trabajo);
			
		}catch(Exception e) {
			log.error(e.toString());
			throw new ServiceException();
		}
	}
}
