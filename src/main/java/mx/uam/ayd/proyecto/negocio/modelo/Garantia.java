package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class Garantia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGarantia;
	
	private String nombreCompleto;
	
	private String fecha;
	
	private String calle;
	
	private String numExt;
	
	private String numInt;
	
	private String descripcionEquipo;
	@OneToOne
	@JoinColumn(name="idNumeroGaratia")
	Compra compra;
}
