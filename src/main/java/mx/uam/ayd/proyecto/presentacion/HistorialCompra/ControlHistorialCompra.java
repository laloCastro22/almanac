package mx.uam.ayd.proyecto.presentacion.HistorialCompra;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCompra;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Compra;



@Component
public class ControlHistorialCompra {
	
	@Autowired
	private VentanaHistorialCompra ventanaHistorialCompra;

	@Autowired
	private ServicioCompra servicioCompra;
	
	/**
	 * El control inicia (muestra) la VentanaHistorialCompra
	 * @param cliente 
	 */
	
	public void inicia(Cliente idCliente) {
		
		List<Compra> listaCompras =servicioCompra.recuperaTodasCompras(idCliente); // El control le pide al ServicioCompra una lista de compras del cliente que se le esta pasando 
		
		ventanaHistorialCompra.muestra(this,listaCompras); //Nos muestra una lista de compras de un cliente
		
	}

}
