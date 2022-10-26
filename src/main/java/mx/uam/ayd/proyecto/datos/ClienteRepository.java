package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Compra;

/**
 * Repositorio para Cliente
 * 
 *
 * @author Erika Maya
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	/**
	 * Encuentra a un cliente a partir de un idCliente
	 * Repositorio para Cliente 
	 * @param idCliente    
	 * @return
	 * 
	 */
	public List <Compra> findByCompras(Cliente cliente);
	public Cliente findByIdCliente(long idCliente);
	
	public List <Cliente>findAll(); // El Repository recupera a una lista de clientes  
	
	//public Cliente findByAll();
	
}
