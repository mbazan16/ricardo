package com.examen.ricardo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.ricardo.enums.Tipo;
import com.examen.ricardo.exceptions.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class IndexController {

	
	@GetMapping("/")
    public String mostrarTipos(Model model) throws ServiceException{
		log.info("[mostrarTrabajo]");
        log.debug("[mostrarTrabajo: "+model.toString()+"]");
        try {
        model.addAttribute("tiposTrabajo", Tipo.values());
        return "index";
        }catch(Exception e){
        	log.error(e.toString());
        	throw new ServiceException();
        }
    }
}
