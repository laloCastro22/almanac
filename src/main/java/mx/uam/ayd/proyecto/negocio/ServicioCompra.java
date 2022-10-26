package mx.uam.ayd.proyecto.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.datos.CompraRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Compra;
/**
 * Servicio relacionado con las compras
 * 
 * @author erikamaya 
 * @author eduardoCastro
 */
@Service
public class ServicioCompra {
	
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * Recupera todas las compras de un cliente.
	 * @param IdCliente 
	 * @return Compras de un cliente
	 */
	
	public List <Compra> recuperaTodasCompras(Cliente idCliente){
		
	    Cliente cliente =  clienteRepository.findByIdCliente(idCliente.getIdCliente());
		
		if( cliente == null) {
			throw new IllegalArgumentException("El cliente no existe "); //Validamos la existencia del cliente que se paso 
		}
		
		List<Compra> compras = clienteRepository.findByCompras(cliente);
		
		if(compras == null) {
			throw new IllegalArgumentException("No se encontraron compras");
		}		
		return compras;
	}
	/**
	 * Retorna una compra si no existe null
	 * @param IdCliente 
	 * @return Compra de un cliente/null
	 */
	
	public Compra obtenCompra(long idCompra) {
		return compraRepository.findById(idCompra); 
	}
}
