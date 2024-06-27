package com.examen.ricardo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.ricardo.entities.Trabajo;
import com.examen.ricardo.exceptions.ServiceException;
import com.examen.ricardo.services.TrabajoServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/trabajo")
public class TrabajoController {

	@Autowired
	TrabajoServicio servicio;
	
	@PostMapping
    public String guardarTrabajo(Model model,@ModelAttribute Trabajo trabajo) throws ServiceException {
        log.info("[guardarTrabajo]");
        log.debug("[guardarTrabajo: "+trabajo.toString()+"]");
		servicio.crearTrabajo(trabajo);
        model.addAttribute("trabajo", trabajo);
        return "t_trabajo"; 
    }
}
