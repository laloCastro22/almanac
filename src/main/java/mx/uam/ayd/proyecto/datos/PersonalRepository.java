package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Personal;

/**
 * Repositorio para Personal
 * 
 * @author 
 *
 */

public interface PersonalRepository extends CrudRepository<Personal, Long> {
	

}
