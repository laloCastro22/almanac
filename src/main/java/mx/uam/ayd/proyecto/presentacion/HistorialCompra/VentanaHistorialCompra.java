package mx.uam.ayd.proyecto.presentacion.HistorialCompra;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Compra;

import javax.swing.JTextField;
//import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.List;
import java.awt.Color;
//import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
@Component
public class VentanaHistorialCompra extends JFrame {

	private JPanel contentPane;
	private JTextField txtServicetec;
	private JLabel lblNewLabel_1;
	private JTextField txtAadirCliente;
	private JTextField txtEditarCliente;
	private JTextField txtEliminarCliente;
	private JTextField textField;
	private JTable tableDatosCliente;
	private JTextField txtHistorialCompras;
	private JTable tableHistorialCompra;
	private ControlHistorialCompra controlCompras;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaHistorialCompra frame = new VentanaHistorialCompra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaHistorialCompra() {
		setTitle("Cliente/Historial Compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\Service Tec\\Service Tec\\src\\main\\java\\imagen\\minilogo computadora.png"));
		lblNewLabel.setBounds(82, 0, 40, 33);
		contentPane.add(lblNewLabel);
		
		txtServicetec = new JTextField();
		txtServicetec.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtServicetec.setBackground(new Color(152, 251, 152));
		txtServicetec.setText("ServiceTec");
		txtServicetec.setBounds(0, 0, 434, 33);
		contentPane.add(txtServicetec); 
		txtServicetec.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\Service Tec\\Service Tec\\src\\main\\java\\imagen\\cliente.png"));
		lblNewLabel_1.setBounds(20, 62, 102, 117);
		contentPane.add(lblNewLabel_1);
		
		txtAadirCliente = new JTextField();
		txtAadirCliente.setText("Añadir Cliente");
		txtAadirCliente.setBounds(20, 174, 102, 20);
		contentPane.add(txtAadirCliente);
		txtAadirCliente.setColumns(10);
		
		txtEditarCliente = new JTextField();
		txtEditarCliente.setText("Editar Cliente");
		txtEditarCliente.setBounds(20, 193, 102, 20);
		contentPane.add(txtEditarCliente);
		txtEditarCliente.setColumns(10);
		
		txtEliminarCliente = new JTextField();
		txtEliminarCliente.setText("Eliminar Cliente");
		txtEliminarCliente.setBounds(20, 213, 102, 20);
		contentPane.add(txtEliminarCliente);
		txtEliminarCliente.setColumns(10);
		
		textField = new JTextField();
		textField.setBackground(new Color(72, 209, 204));
		textField.setBounds(20, 48, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Datos del Cliente ");
		lblNewLabel_2.setForeground(new Color(34, 139, 34));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(160, 44, 143, 24);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 76, 292, 44);
		contentPane.add(scrollPane);
		
		tableDatosCliente = new JTable();
		/*tableDatosCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Nombre", "Tel\u00E9fono", "Correo", "Direcci\u00F3n"
			}
		));*/
		scrollPane.setViewportView(tableDatosCliente);
		
		txtHistorialCompras = new JTextField();
		txtHistorialCompras.setBackground(new Color(192, 192, 192));
		txtHistorialCompras.setText("Historial Compras");
		txtHistorialCompras.setBounds(132, 124, 292, 20);
		contentPane.add(txtHistorialCompras);
		txtHistorialCompras.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(132, 145, 292, 88);
		contentPane.add(scrollPane_1);
		
		tableHistorialCompra = new JTable();
		tableHistorialCompra.setModel(new DefaultTableModel(
			new Object[][] {
				{55, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID Compra", "Fecha", "Cantidad"
			}
		));
		scrollPane_1.setViewportView(tableHistorialCompra);
	}
	
	/*
	 * Este método nos muestra la ventana de nuestra historia de usuario HU-06 
	 */
	public void muestra(ControlHistorialCompra control, List <Compra> listaCompras) {
		controlCompras = control;
		DefaultTableModel model1= new DefaultTableModel();
		model1.addColumn("Nombre Cliente");
		model1.addColumn("Teléfono");
		model1.addColumn("Correo");
		model1.addColumn("Dirección");
        
		/*for(Cliente cliente:clienteS) {
			
			Object[] fila =new Object[4];
			fila[0]=cliente.getNombreCompleto();
			fila[1]=cliente.getTelefono();
			fila[2]=cliente.getCorreo();
			fila[3]=cliente.getDireccionEntrega();
			model1.addRow(fila);	
		}*/
		DefaultTableModel model2= new DefaultTableModel();
		model2.addColumn("IdCompra");
		model2.addColumn("Fecha");
		model2.addColumn("Cantidad");
		
		for(Compra compra:listaCompras) {
			
			Object[] fila =new Object[3];
			fila[0]=compra.getIdCompra();
			fila[1]=compra.getFecha();
			fila[2]=compra.getCantidad();
			model2.addRow(fila);	
		}
		tableDatosCliente.setModel(model1);
		tableHistorialCompra.setModel(model2);
		setVisible(true);
	}
}
