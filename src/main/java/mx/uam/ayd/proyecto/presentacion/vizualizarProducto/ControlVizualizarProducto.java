package mx.uam.ayd.proyecto.presentacion.vizualizarProducto;

/**
 * 
 * Módulo de control para la historia de usuario VisualizarProducto
 * 
 * @author Eduardo Castro
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

import java.util.List;

@Component
public class ControlVizualizarProducto {
	
	@Autowired
	private ServicioProducto servicioProducto;
	
	@Autowired
	private VistaVizualizarProducto vistaVizualizarProducto;
	/**
	 * Inicia la historia de usuario
	 * 
	 */
	public void inicia(){
		
		List <Producto>  producto = servicioProducto.recuperaListaProductos();
		
		vistaVizualizarProducto.muestra(this, producto);
		
	}
	
	

}
