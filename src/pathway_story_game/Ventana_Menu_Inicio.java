package pathway_story_game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Ventana_Menu_Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private File ruta = new File("../partidas");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Menu_Inicio frame = new Ventana_Menu_Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana_Menu_Inicio() {
	
		
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 765, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 20, 704, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setIcon(new ImageIcon(Ventana_Menu_Inicio.class.getResource("/assets/portada.png")));
		lblNewJgoodiesLabel.setBounds(0, 0, 704, 469);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 153));
		panel_1.setBounds(22, 509, 704, 61);
		contentPane.add(panel_1);
		
		JButton btnContinuarHistoria = new JButton("Continuar Partida");
		btnContinuarHistoria.setFocusPainted(false);
		btnContinuarHistoria.setBounds(162, 12, 166, 37);
		
		if(ruta.list() == null || ruta.list().length == 0) {
			btnContinuarHistoria.setEnabled(false);
		}else {
			btnContinuarHistoria.setEnabled(true);
			btnContinuarHistoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Ventana_Continuar_Partida frame = new Ventana_Continuar_Partida();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				}
			});
		}
		
		
		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.setFocusPainted(false);
		btnNuevaPartida.setBounds(5, 12, 152, 37);
		btnNuevaPartida.setActionCommand("Nueva Partida");
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (ruta.exists()) {
					Ventana_Crear_Partida frame = new Ventana_Crear_Partida();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				}else {
					File carpeta = new File("../partidas") ;
					carpeta.mkdir() ;
					Ventana_Crear_Partida frame = new Ventana_Crear_Partida();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				}
				
				
			}
		});
		
		JButton btnFinalesDescubiertos = new JButton("Finales Descubiertos");
		btnFinalesDescubiertos.setFocusPainted(false);
		btnFinalesDescubiertos.setBounds(333, 12, 180, 37);
		
		if(ruta.list() == null || ruta.list().length == 0) {
			btnFinalesDescubiertos.setEnabled(false);
		}else {
			btnFinalesDescubiertos.setEnabled(true);
			btnFinalesDescubiertos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Ventana_Finales frame = new Ventana_Finales();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				}
			});
		}
		
		
		panel_1.setLayout(null);
		panel_1.add(btnNuevaPartida);
		panel_1.add(btnContinuarHistoria);
		panel_1.add(btnFinalesDescubiertos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFocusPainted(false);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(518, 12, 180, 37);
		panel_1.add(btnSalir);

	}
}
