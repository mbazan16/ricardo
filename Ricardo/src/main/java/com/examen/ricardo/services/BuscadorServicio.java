package com.examen.ricardo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.ricardo.entities.Trabajo;
import com.examen.ricardo.exceptions.ServiceException;
import com.examen.ricardo.repositories.TrabajoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BuscadorServicio implements IBuscadorServicio{

	@Autowired
	TrabajoRepository repository;
	
	public List<Trabajo> servicioBuscador(String nombre) throws ServiceException{
		log.info("[servicioBuscador]");
		log.debug("[servicioBuscador: " +nombre+"]");
		
		List<Trabajo> trabajos = new ArrayList<Trabajo>();
		
		try {
			if(nombre == null|| nombre.trim().isEmpty()) {
				nombre="";
			}
			
			trabajos = repository.findByNameLike(nombre);
		
		}catch(Exception e) {
			log.error(e.toString());
			throw new ServiceException();
		}
	
		return trabajos;
	}
		
}
