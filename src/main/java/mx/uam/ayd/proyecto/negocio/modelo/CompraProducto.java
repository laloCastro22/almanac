package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entidad de negocio CompraProducto
 * 
 * @author abigailmorales
 * @author erikamaya
 * @author eduardocastro
 *
 */
@Entity
@Data
public class CompraProducto {
	
	@Id
	private long idCompraProducto;

	private long idProducto;
	
	private double precioTotal;
	
	private int cantidad;
	

}
