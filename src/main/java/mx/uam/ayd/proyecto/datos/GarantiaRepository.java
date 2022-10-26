package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;


import mx.uam.ayd.proyecto.negocio.modelo.Garantia;
/**
 * Repositorio para Garantia
 * 
 * @author Eduardo Castro
 *
 */

public interface GarantiaRepository extends CrudRepository<Garantia, Long> {
	/**
	 * Guarda una Garantía a partir de una idCompra
	 * Repositorio para Garantía  
	 * @param garantia
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public Garantia save(Garantia garantia);
}
