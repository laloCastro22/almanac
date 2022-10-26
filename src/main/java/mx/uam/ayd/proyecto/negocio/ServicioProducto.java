package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.datos.SeccionCatalogoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;
/**
 * Servicio relacionado con los productos
 * 
 * @author abigailmorales 
 * @author eduardoCastro
 */

@Slf4j
@Service
public class ServicioProducto {
	
	@Autowired 
	private ProductoRepository productoRepository; 
	
	@Autowired
	private SeccionCatalogoRepository seccionCatalogoRepository; 
	
	
	
	/**
	 * 
	 * Permite agregar un producto a la seccion catalogo que se desea 
	 * Nota: un mismo producto no puede registrar dos veces (Regla del Negocio 02)
	 * 
	 * @param nombre
	 * @param marca
	 * @param descripcion
	 * @param precio
	 * @param descuento
	 * @param existencia
	 * @param seccion
	 * @return true si el producto se agregó correctamente, false si ya estaba en la SeccionCatalogo
	 * @throws IllegalArgumentException si el producto ya existe 
	 * @throws IllegalArgumentException si no se encontro la seccion del catalogo a la que se quiere agregar el producto
	 */
	
	public boolean agregaProducto(String nombre, String marca, String descripcion, String precio, String descuento,
			String existencia, String seccion) {

		// Regla de negocio: No se permite agregar dos productos con el mismo nombre

		if (validarMaximoProductos(seccion)) {
			
			Producto producto = productoRepository.findByNombre(nombre);
			
			if (producto != null) {
				throw new IllegalArgumentException("El producto ya existe");
			}

			SeccionCatalogo seccionCatalogo = seccionCatalogoRepository.findByNombre(seccion);

			if (seccionCatalogo == null) {
				throw new IllegalArgumentException("No se encontró la sección del catalogo");
			}

			log.info("Agregando producto con nombre: " + nombre + ", marca:" + marca + ", descripcion:" + descripcion
					+ ", precio:" + precio + ", descuento:" + descuento + ", existencia:" + existencia + ", seccion:"
					+ seccion);

			producto = new Producto();

			producto.setNombre(nombre);
			producto.setMarca(marca);
			producto.setDescripcion(descripcion);
			producto.setPrecio(Double.parseDouble(precio));
			producto.setDescuento(Double.parseDouble(descuento));
			producto.setExistencia(Integer.parseInt(existencia));

			productoRepository.save(producto);
			seccionCatalogo.addProducto(producto);

			seccionCatalogoRepository.save(seccionCatalogo);
			

			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * 
	 * Valida que no se sobrepase el valor máximo asignado para agregar productos en la sección correspondiente 
	 * 
	 * @param seccion
	 * @return true si aun no execede el valor maximo asignado de registros en la sección correspondiente 
	 * @return false si ya se execede el valor maximo asignado de registros en la sección correspondiente
	 */
	
	boolean validarMaximoProductos(String seccion) {
		 if(seccionCatalogoRepository.findByNombre(seccion).getProductos().size()>2)
			 return false;
		 else 
			 return true; 
	}
	
	
	/**
	 * 
	 * Recupera un listado de todas los productos disponibles en la base de datos 
	 * 
	 * @param 
	 * @return Una lista con todos los productos disponibles en la base de datos 
	 */
	
	public List <Producto> consultarProductosDisponibles() {
		
		List <Producto> productos = new ArrayList<>();
		
		for(Producto producto:productoRepository.findAll()) {
			productos.add(producto);
		}
				
		return productos;
	}
	
	/**
	 * 
	 * Recupera un producto de acuerdo a su nombre 
	 * 
	 * @param nombre
	 * @return un objeto de tipo Producto si este se encontro en la base de datos 
	 * @throws IllegalArgumentException si el producto no existe
	 */
	
	public Producto obtenerProducto(String nombre) {
		
		Producto producto = productoRepository.findByNombre(nombre);
		
		if (producto == null) {
			throw new IllegalArgumentException("El producto no existe");
		}else
			return producto; 
	}
	
	/**
	 * 
	 * Permite obtener una seccion del catalogo de acuerdo a un producto de este 
	 * 
	 * @param producto
	 * @return un objeto de tipo SeccionCatalogo si este se encontro en la base de datos 
	 * @throws IllegalArgumentException si el producto no existe en la seccion
	 */
	
	public SeccionCatalogo obtenerSeccionCatalogoDelProducto(Producto producto) {
		SeccionCatalogo seccionCatalogo=seccionCatalogoRepository.findByProductos(producto); 
		if (seccionCatalogo == null) {
			throw new IllegalArgumentException("El producto no existe en esta seccion");
		}else
			return seccionCatalogo;
	}
	
	/**
	 * 
	 * Permite modificar un producto existente en la base de datos
	 * 
	 * @param nombreProductoAModificar
	 * @param nombre
	 * @param marca
	 * @param descripcion
	 * @param precio
	 * @param descuento
	 * @param existencia
	 * @return producto si se modifico correctamente el producto
	 * @throws IllegalArgumentException si el producto no existe 
	 */
	
	public Producto modificaProducto(String nombreProductoAModificar, String nombre, String marca, String descripcion, String precio, String descuento,String existencia) {

			
			Producto producto = productoRepository.findByNombre(nombreProductoAModificar);

			if (producto == null) {
				throw new IllegalArgumentException("El producto no existe");
			}

			log.info("Modificando el producto con nombre: " + nombre + ", marca:" + marca + ", descripcion:" + descripcion
					+ ", precio:" + precio + ", descuento:" + descuento + ", existencia:" + existencia);
			
			if(!nombre.equals("")) {
				producto.setNombre(nombre);
			}
			if(!marca.equals("")) {
				producto.setMarca(marca);
			}
			if(!descripcion.equals("")) {
				producto.setDescripcion(descripcion);
			}
			if(!precio.equals("")) {
				producto.setPrecio(Double.parseDouble(precio));
			}
			if(!descuento.equals("")) {
				producto.setDescuento(Double.parseDouble(descuento));
			}
			if(!existencia.equals("")) {
				producto.setExistencia(Integer.parseInt(existencia));
			}
			
			producto=productoRepository.save(producto);
			
			return producto;

	}
	/**
	 * 
	 * Permite agregar recuperar la lista de usuarios
	 * 
	 * 
	 * @return lista de productos (o una lista vacia)
	 */
	
	public List<Producto> recuperaListaProductos(){
		
		List <Producto> listaProductos = new ArrayList <>();
		
		 for(Producto producto: productoRepository.findAll()) {
			 listaProductos.add(producto);
		 }
		 
		return listaProductos;
	}
}
