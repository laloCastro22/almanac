package mx.uam.ayd.proyecto.negocio.modelo;
//Entidad de negocio Cliente

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entidad de negocio Personal
 * 
 * @author abigailmorales
 * @author erikamaya
 * @author eduardocastro
 *
 */

@Entity
@Data
public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersonal;
	
	private String nombre;
	
	private String apellido;
    
	private String telefonoPersonal;
    
	private String cargo;
       
}
