package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entidad de negocio Producto
 * 
 * @author abigailmorales
 * @author erikamaya
 * @author eduardocastro
 *
 */

@Entity
@Data
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProducto;
	
	private String nombre;
	
	private String descripcion;
	
	private int totalComprasProducto;
	
	private double precio;
	
	private int existencia;
	
	private String marca;
	
	private double descuento;

}
