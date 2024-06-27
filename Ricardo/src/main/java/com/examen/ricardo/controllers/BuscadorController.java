package com.examen.ricardo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examen.ricardo.entities.Trabajo;
import com.examen.ricardo.exceptions.ServiceException;
import com.examen.ricardo.services.IBuscadorServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/buscador")
public class BuscadorController {
	
	@Autowired
	IBuscadorServicio servicio;
	
	@GetMapping
	public String buscador(Model model,@RequestParam(required=false) String cadena) throws ServiceException {
		log.info("[buscador]");
		log.debug("[buscador: "+cadena+"]");
		List<Trabajo> trabajos=servicio.servicioBuscador(cadena);
		model.addAttribute("trabajos", trabajos);				
		
		log.info("Devolviendo vista 't_buscador'");
		return "t_buscador";
	}
}
