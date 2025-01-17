package com.hlc.etiquetas.config;
import org.springframework.stereotype.Component;

import com.hlc.etiquetas.entidad.Etiqueta;
import com.hlc.etiquetas.repositorio.EtiquetaRepositorio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {

    private final EtiquetaRepositorio etiquetaRepositorio;

    public InicializarDatos(EtiquetaRepositorio etiquetaRepositorio) {
        this.etiquetaRepositorio = etiquetaRepositorio;
    }
    
    @PostConstruct
    public void init() {
    	try {
    		  // Crear etiquetas de ejemplo
            Etiqueta etiqueta1 = new Etiqueta("Urgente", "Etiqueta para tareas urgentes", true, 1, "Rojo");
            Etiqueta etiqueta2 = new Etiqueta("Importante", "Etiqueta para tareas importantes", true, 2, "Amarillo");
            Etiqueta etiqueta3 = new Etiqueta("Opcional", "Etiqueta para tareas opcionales", true, 5, "Azul");
            //Se añade un color a cada etiqueta para que funcione con el nuevo atributo

            // Guardar en el repositorio
            etiquetaRepositorio.save(etiqueta1);
            etiquetaRepositorio.save(etiqueta2);
            etiquetaRepositorio.save(etiqueta3);
    	}catch(Exception ex) {
    		System.err.println("InicializarDatos-->init() :: "+ex.toString());
    	}
      
    }
}