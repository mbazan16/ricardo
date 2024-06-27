package com.examen.ricardo.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.examen.ricardo.entities.Trabajo;
import com.examen.ricardo.enums.Tipo;
import com.examen.ricardo.exceptions.ServiceException;
import com.examen.ricardo.repositories.TrabajoRepository;

@ExtendWith(MockitoExtension.class) 
public class TrabajoServicioTest {

    @Mock
    TrabajoRepository repositorio;

    @InjectMocks
    private TrabajoServicio servicio; 

    @Test
    public void testCrearTrabajo() throws ServiceException {
        Trabajo trabajo = new Trabajo();
        trabajo.setNombre("Desarrollador");
        trabajo.setTipo(Tipo.REMOTO);

        when(repositorio.save(trabajo)).thenReturn(trabajo);

        servicio.crearTrabajo(trabajo);

        verify(repositorio, times(1)).save(trabajo);
  
    }
}