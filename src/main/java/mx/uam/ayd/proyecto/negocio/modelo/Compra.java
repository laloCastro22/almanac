package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import lombok.Data;


/**
 * Entidad de negocio Compra
 * 
 * @author abigailmorales
 * @author erikamaya
 * @author eduardocastro
 *
 */

@Entity
@Data
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCompra;
	
	private int cantidad;
	
	private String fecha;
	
	private String estadoCompra;
	
	private String viaCompra; 

	@OneToOne
	private Garantia garantia;
}
