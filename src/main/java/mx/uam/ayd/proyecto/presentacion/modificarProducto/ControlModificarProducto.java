package mx.uam.ayd.proyecto.presentacion.modificarProducto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;

/**
 * 
 * Módulo de control para la historia de usuario ModificarProducto
 * 
 * @author abigailmorales
 *
 */
@Component
public class ControlModificarProducto {
	
	@Autowired 
	private ServicioProducto servicioProducto; 
	
	@Autowired 
	private VentanaModificarProducto ventana;
	
	/**
	 * 
	 * Permite dar inicio al módulo ControlModificarProducto y a sus respectivos métodos de dicho módulo   
	 * 
	 */
	public void inicia() {
		
		List <Producto> productos = servicioProducto.consultarProductosDisponibles(); 
		ventana.muestra(this, productos);
	}
	
	
	/**
	 * 
	 * Manda a llamar al método obtenerProducto() del módulo ServicioProducto pasandole los mismos parámetros recibidos 
	 * 
	 * @param producto
	 * @param nombre
	 * @param marca
	 * @param descripcion
	 * @param precio
	 * @param descuento
	 * @param existencia
	 * @param seccion
	 * @return Dialogo con mensaje 
	 */
	
	public void modificaProducto(String producto, String nombre, String marca, String descripcion, String precio, String descuento,
			String existencia) {

		try {

			servicioProducto.modificaProducto(producto, nombre, marca, descripcion, precio, descuento, existencia);

			ventana.muestraDialogoConMensaje("El producto "+producto+" ha sido modificado exitosamente");
			termina();

		} catch (Exception ex) {
			ventana.muestraDialogoConMensaje("Error al modificar producto: " + ex.getMessage());
		}

		termina();
	}
	
	/**
	 * 
	 * Manda a llamar al método obtenerProducto() del módulo ServicioProducto pasandole los mismos parámetros recibidos 
	 * 
	 * @param nombre
	 * @return producto 
	 */
	
	public Producto obtenerProducto(String nombre) {
		Producto producto=servicioProducto.obtenerProducto(nombre);
		return producto; 
	}
	
	/**
	 * 
	 * Manda a llamar al método obtenerSeccionCatalogoDelProducto() del módulo ServicioProducto pasandole los mismos parámetros recibidos  
	 * 
	 * @param producto
	 * @return seccion
	 */
	
	public SeccionCatalogo obtenerSeccionCatalogoDelProducto(Producto producto) {
		SeccionCatalogo seccion=servicioProducto.obtenerSeccionCatalogoDelProducto(producto);
		return seccion; 
	}
	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	public void termina() {
		ventana.setVisible(false);		
	}

}
