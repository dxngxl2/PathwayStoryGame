package pathway_story_game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Ventana_Crear_Partida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String[] lista_ficheros;
	private File ruta = new File("../partidas");


	public Ventana_Crear_Partida() {
		if(ruta.list() == null) {			
		}else {
			lista_ficheros = ruta.list();	
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(54, 26, 326, 143);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Introduzca su nombre");
		lblNewLabel.setBounds(51, 12, 223, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		textField = new JTextField();
		textField.setText("");
		textField.setBounds(43, 55, 239, 31);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Crear Partida");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Rellena el campo primero");
				} else {
					String nombre_partida = textField.getText();
					
					boolean fichero_encontrado = false;
					
					if (ruta.list() != null) {
						
						for (int i = 0; i < lista_ficheros.length; i++) {
							if (lista_ficheros[i].equalsIgnoreCase(nombre_partida+".dat")) {
								fichero_encontrado = true;
							}else {
								fichero_encontrado = false;
							}
						}
						
						if (fichero_encontrado == false) {
							
							Partida nueva_partida = new Partida(nombre_partida);
							String path = "../partidas/" + nombre_partida + ".dat";
							
							try {
								ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
								oos.writeObject(nueva_partida);
								oos.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
							Ventana_Juego frame = new Ventana_Juego(nombre_partida);
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							dispose();
							
						}else {
							JFrame jFrame = new JFrame();
							JOptionPane.showMessageDialog(jFrame, "El nombre del fichero ya existe");
						}
					}
					
				}

			}
		});
		btnNewButton.setBounds(0, 112, 139, 31);
		panel.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Menu_Inicio frame = new Ventana_Menu_Inicio();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCancelar.setBounds(187, 112, 139, 31);
		panel.add(btnCancelar);
	}
}
