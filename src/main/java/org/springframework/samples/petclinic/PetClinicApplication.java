package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*A
1 Obtener una lista de Vets filtrados por lastName
2 Obtener una lista de Vets filtrados por firstName y lastName
3 Obtener una lista de Vets buscando en firstName o lastName

B Organizar el código apra que esté en base a servicios y no sean llamadas directas de controller a dao.class

C Crear métodos y usarlos desde cualquier parte del código
4 Obtener las mascotas nacidas en 2010 ordenadas por fecha de nacimiento ascendente
5 Crear 3 visitas nuevas para diferentes mascotas
6 Obtener todas las visitas para una mascota
7 Obtener las 4 visitas más recientes de todo el sistema*/



@SpringBootApplication
public class PetClinicApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}
}
