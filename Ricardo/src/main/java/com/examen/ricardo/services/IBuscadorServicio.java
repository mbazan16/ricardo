package com.examen.ricardo.services;

import java.util.List;

import com.examen.ricardo.entities.Trabajo;
import com.examen.ricardo.exceptions.ServiceException;

public interface IBuscadorServicio {

	public List<Trabajo> servicioBuscador(String nombre) throws ServiceException;
}
