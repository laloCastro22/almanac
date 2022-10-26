package mx.uam.ayd.proyecto.presentacion.principal;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
@SuppressWarnings("serial")
@Component
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	
	private ControlPrincipal controlPrincipal;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("Menú principal/ServiceTEC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 205, 170));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("            Catálogo          ");
		mnNewMenu.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.agregarProducto();
			}
		});
		mntmNewMenuItem.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.modificarProducto();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Eliminar");
		mntmNewMenuItem_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("      Clientes      ");
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.obtenerDatos();
			}
		});
		mnNewMenu_1.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("        Ventas        ");
		mnNewMenu_2.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Garantía ");
		mntmNewMenuItem_3.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlPrincipal.creaGarantia();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Más Vendidos ");
		mntmNewMenuItem_4.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlPrincipal.listaProductosMasComprados();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon("C:\\Users\\Abi\\Downloads\\Service%20Tec\\src\\main\\java\\imagen\\compu.png"));
		lblIcono.setBounds(283, 49, 163, 134);
		contentPane.add(lblIcono);
		
		JLabel lblTitulo = new JLabel("ServiceTEC");
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.BOLD, 32));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(121, 68, 163, 85);
		contentPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 520, 234);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Abi\\Downloads\\Service%20Tec\\src\\main\\java\\imagen\\fondoP2.jpg"));
		contentPane.add(lblFondo);
	}
	public void muestra(ControlPrincipal control) {
		
		controlPrincipal = control;
		setVisible(true);
	}
}
