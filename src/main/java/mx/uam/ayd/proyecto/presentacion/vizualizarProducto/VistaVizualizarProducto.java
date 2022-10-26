package mx.uam.ayd.proyecto.presentacion.vizualizarProducto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
@SuppressWarnings("serial")
@Component
public class VistaVizualizarProducto extends JFrame {
	
	
	ControlVizualizarProducto controlVizualizarProducto;
	
	private JPanel contentPane;
	private JTable table;
	
	List <Producto> productos = new ArrayList <Producto>();

	
	public VistaVizualizarProducto() {
		setTitle("Productos más comprados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de compras");
		lblNewLabel.setBounds(213, 23, 194, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.setBounds(477, 331, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton);
		
		Object[] colName = {"Numero de ventas","Nombre del producto", "Existencias"};
		Object[][] datos = new Object[5][3];
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<3;j++) {
				datos[i][j] = null;
			}
		}
		DefaultTableModel model = new DefaultTableModel(datos, colName);
		
		JTable tabla = new JTable(model) {
			private static final long serialVersionUID = 1L;
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return Integer.class;
				default:
					return String.class;
				}
			
			}
		};
		int i = 0, j=0;
		//System.out.println(productos.size());
		tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
		tabla.setBounds(30, 88, 552, 200);
		
		
		contentPane.add(tabla);
		


		
	}
	
	public void muestra(ControlVizualizarProducto control, List<Producto>  producto) {
		
		productos=producto;
		
		controlVizualizarProducto = control;
		setVisible(true);
	}
}
