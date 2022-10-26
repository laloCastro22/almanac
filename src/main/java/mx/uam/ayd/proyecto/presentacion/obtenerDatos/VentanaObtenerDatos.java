package mx.uam.ayd.proyecto.presentacion.obtenerDatos;
import java.awt.Font;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
@Component
public class VentanaObtenerDatos extends JFrame {

	private JPanel contentPane;
	private ControlObtenerDatos controlDatos;
	private JTextField txtListaDeClientes;
	private JTable tablaClientes;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaObtenerDatos frame = new VentanaObtenerDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaObtenerDatos() {
		setTitle("Clientes ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Menú principal/ServiceTEC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(204, 204, 153));
		menuBar.setBackground(new Color(204, 204, 153));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("            Catálogo          ");
		mnNewMenu.setBackground(new Color(204, 204, 153));
		mnNewMenu.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar ");
		mntmNewMenuItem.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar");
		mntmNewMenuItem_1.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Eliminar");
		mntmNewMenuItem_2.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("      Clientes      ");
		mnNewMenu_1.setBackground(new Color(204, 204, 153));
		mnNewMenu_1.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("        Ventas        ");
		mnNewMenu_2.setBackground(new Color(46, 139, 87));
		mnNewMenu_2.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Garantía ");
		mntmNewMenuItem_3.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_3.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu_2.add(mntmNewMenuItem_3);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtListaDeClientes = new JTextField();
		txtListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		txtListaDeClientes.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		txtListaDeClientes.setBackground(new Color(127, 255, 212));
		txtListaDeClientes.setText("Lista de clientes");
		txtListaDeClientes.setBounds(0, 0, 434, 29);
		contentPane.add(txtListaDeClientes);
		txtListaDeClientes.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 414, 183);
		contentPane.add(scrollPane);
		
		tablaClientes = new JTable();
		model = new DefaultTableModel();
		tablaClientes.setModel(model);
		
		//Creamos las columnas al modelo 
		
		model.addColumn("Nombre Cliente");
		model.addColumn("Teléfono");
		model.addColumn("Correo");
		model.addColumn("Dirección");
		model.addColumn("Compra");
		
		scrollPane.setViewportView(tablaClientes);
	}
	
	/*
	 * Este método nos muestra la ventana de nuestra historia de usuario HU-05 
	 */
	public void muestra(ControlObtenerDatos control, List <Cliente> listaClientes) {
		controlDatos = control;
		for(Cliente cliente:listaClientes) {
			
			Object[] fila =new Object[5];
			fila[0]=cliente.getNombreCompleto();
			fila[1]=cliente.getTelefono();
			fila[2]=cliente.getCorreo();
			fila[3]=cliente.getDireccionEntrega();
			fila[4]="";
			
			model.addRow(fila);
		}
		tablaClientes.setModel(model);
		setVisible(true);
	}
}
