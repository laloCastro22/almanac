package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
/**
 * Servicio relacionado con el Cliente
 * 
 * @author erikamaya 
 * 
 */

@Service
public class ServicioCliente {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * Recupera todos los clientes existentes 
	 * Contrato:
	 * @return Una lista con todos los clientes existentes
	 *         Una lista vacía 
	 */	
	public List <Cliente> recuperaTodosClientes(){ 
		System.out.println("clienteRepository = "+clienteRepository);
		
		List <Cliente> listaClientes =new ArrayList<>();
		
		for(Cliente cliente:clienteRepository.findAll()) {  
			listaClientes.add(cliente);
		}
		return listaClientes;
	}
	
}
