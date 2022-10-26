package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
/**
 * Implementacion de las pruebas unitarias del ServicioCliente
 * 
 * @author Erika Maya Perez
 * 
 *
 */

@ExtendWith(MockitoExtension.class)
class ServicioClienteTest {
	
	
	@Mock //genera un sustituto
	private ClienteRepository clienteRepository;
	@InjectMocks
	private ServicioCliente servicioClienteDatos;

	@Test
	void testRecuperaTodosClientes() {
		//Caso de prueba No.1: Regresa una lista vacía
				/*
				 * Simulamos la reposición del repositorio usando un sustituto
				*/
				
				List <Cliente> clientes = servicioClienteDatos.recuperaTodosClientes();
				assertEquals(0,clientes.size());
	    //Caso de prueba No.2: Regresa una lista con todos los clientes que se encuentran en la base de datos.
				/*
				 * Como clienteRepository.findAll() regresa un Iterable usamos ArrayList
				 * Creamos 3 cliente y los agregamos a "listaClientes" 
				 */
				ArrayList <Cliente> listaClientes = new ArrayList <>();
				
				Cliente cliente1=new Cliente();
				cliente1.setNombreCompleto("Juan Pérez");
				cliente1.setTelefono("5561330399");
				cliente1.setCorreo("juan123@gmail.com");
				cliente1.setDireccionEntrega("Calle 33 #113 Col. Santa Cruz Meyehualco");
				
				Cliente cliente2=new Cliente();
				cliente2.setNombreCompleto("Maria Flores");
				cliente2.setTelefono("5588220302");
				cliente2.setCorreo("Mari456@gmail.com");
				cliente2.setDireccionEntrega("Calle Rosas #12 Col. Doctores");
				
				Cliente cliente3=new Cliente();
				cliente3.setNombreCompleto("Martin Maya");
				cliente3.setTelefono("5612752187");
				cliente3.setCorreo("Martinm09@gmail.com");
				cliente3.setDireccionEntrega("Calle Jacarandas #22 Col. Vicente Guerrero");
				
				listaClientes.add(cliente1);
				listaClientes.add(cliente2);
				listaClientes.add(cliente3);
				
				when(clienteRepository.findAll()).thenReturn(listaClientes);
				clientes = servicioClienteDatos.recuperaTodosClientes();
				assertEquals(3,clientes.size());
	}
}
