package mx.uam.ayd.proyecto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.datos.CompraRepository;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.datos.SeccionCatalogoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Compra;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;



/**
 * 
 * Clase principal que arranca la aplicación 
 * construida usando el principio de 
 * inversión de control
 * 
 * 
 * @author Humberto Cervantes (c) 9 Dic 2021
 *
 */
@SpringBootApplication
public class ProyectoApplication {

	@Autowired
	ControlPrincipal controlPrincipal;
	
	@Autowired
	SeccionCatalogoRepository seccionCatalogoRepository; 
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CompraRepository compraRepository;
	/**
	 * 
	 * Método principal
	 *
	 * @params args argumentos de la línea de comando
	 * 
	 */
	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}

	/**
	 * Metodo que arranca la aplicacion
	 * inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {
		
		inicializaBD();
		
		controlPrincipal.inicia();
	}
	
	
	/**
	 * 
	 * Inicializa la BD con datos
	 * 
	 * 
	 */
	public void inicializaBD() {
		
		// Vamos a crear los dos grupos de usuarios
		
		SeccionCatalogo seccionImpresora = new SeccionCatalogo();
		seccionImpresora.setNombre("Impresora");
		seccionCatalogoRepository.save(seccionImpresora);
		
		SeccionCatalogo seccionProcesador = new SeccionCatalogo();
		seccionProcesador.setNombre("Procesadores");
		
		SeccionCatalogo seccionTarjetaMadre = new SeccionCatalogo();
		seccionTarjetaMadre.setNombre("Tarjetas Madres");
		seccionCatalogoRepository.save(seccionTarjetaMadre);
		
		SeccionCatalogo seccionMonitor = new SeccionCatalogo();
		seccionMonitor.setNombre("Monitores");
		seccionCatalogoRepository.save(seccionMonitor);
		
		SeccionCatalogo seccionDiscoDuro = new SeccionCatalogo();
		seccionDiscoDuro.setNombre("Discos Duros");
		seccionCatalogoRepository.save(seccionDiscoDuro);
		
		SeccionCatalogo seccionLaptop = new SeccionCatalogo();
		seccionLaptop.setNombre("Laptops");
		seccionCatalogoRepository.save(seccionLaptop);
		
		Cliente cliente1=new Cliente();
		cliente1.setNombreCompleto("Juan");
		cliente1.setTelefono("5561330399");
		cliente1.setCorreo("juan123@gmail.com");
		cliente1.setDireccionEntrega("Calle 33 #113 Col. Santa Cruz Meyehualco");
		clienteRepository.save(cliente1);
		
		var productoPrueba = new Producto();
		 
		productoPrueba.setNombre("Core i3");
		productoPrueba.setMarca("Intel");
		productoPrueba.setDescripcion("10100F Comet Lake Quad - Procesador de sobremesa, Core 3,6 GHz, 6 MB, LGA 1200, 65W, 4C / 8T");
		productoPrueba.setPrecio(1499.90);
		productoPrueba.setDescuento(15);
		productoPrueba.setExistencia(7);
		productoPrueba.setTotalComprasProducto(0);
		
		seccionProcesador.addProducto(productoPrueba);
		
		//productoRepository.save(productoPrueba);
		seccionCatalogoRepository.save(seccionProcesador);
		
		var compraPrueba = new Compra();
		compraPrueba.setCantidad(2);
		compraPrueba.setEstadoCompra("Mexico");
		compraPrueba.setFecha("23/05/2022");
		compraPrueba.setGarantia(null);
		compraPrueba.setIdCompra(1);
		compraPrueba.setViaCompra("Internet");
		
		compraRepository.save(compraPrueba);
		
		
		
		
		

		}
}
