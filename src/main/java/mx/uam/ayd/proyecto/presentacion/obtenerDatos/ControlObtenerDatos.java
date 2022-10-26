package mx.uam.ayd.proyecto.presentacion.obtenerDatos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.presentacion.HistorialCompra.ControlHistorialCompra;


@Component
public class ControlObtenerDatos {
	
	@Autowired
	private VentanaObtenerDatos ventanaDatos;
	
	@Autowired
	private ServicioCliente servicioCliente;
	
	@Autowired
	private ControlHistorialCompra controlHistorialCompra;
	
	/**
	 * El control inicia (muestra) la VentanaObtenrDatos 
	 */
	public void inicia() {
		
		List <Cliente> listaClientes =servicioCliente.recuperaTodosClientes(); // El control le pide al ServicioClientes una lista de clientes 
		
		ventanaDatos.muestra(this, listaClientes); // La ventana me va a mostrar una lista de clientes
	}
	
	/**
	 * Método que arranca la historia de usuario "historial compra"
	 * @param Cliente
	 */
	public void historialCompra(Cliente idCliente) {
		
		controlHistorialCompra.inicia(idCliente);
	}
	
	
} 
