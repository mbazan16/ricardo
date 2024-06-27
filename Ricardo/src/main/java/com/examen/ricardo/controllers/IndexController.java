package com.examen.ricardo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.ricardo.entities.Trabajo;
import com.examen.ricardo.enums.Tipo;
import com.examen.ricardo.exceptions.ServiceException;
import com.examen.ricardo.services.IndexServicio;
import com.examen.ricardo.services.TrabajoServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class IndexController {

	@Autowired
	IndexServicio servicio;
	
	@GetMapping("/")
    public String mostrarIndice(Model model) throws ServiceException{
		log.info("[mostrarTrabajo]");
        log.debug("[mostrarTrabajo: "+model.toString()+"]");
        model.addAttribute("tiposTrabajo", Tipo.values());
        return "index";
    }
}
