package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;


/**
 * Entidad de negocio Cliente
 * 
 * @author abigailmorales
 * @author erikamaya
 * @author eduardocastro
 *
 */
@Entity
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;

	private String contraseña;
	
	private String correo; 
	
	private String nombreCompleto;
	
	private String telefono;
	
	private String direccionEntrega;
    
	 @OneToMany(targetEntity = Cliente.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
	 @JoinColumn(name= "idCompra")
	 private final List <Compra> compras = new ArrayList <> ();
    
    
    

}
