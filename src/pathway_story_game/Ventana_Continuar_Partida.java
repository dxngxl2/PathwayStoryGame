package pathway_story_game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Ventana_Continuar_Partida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private String[] lista_ficheros;
	private File ruta = new File("../partidas");


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Ventana_Continuar_Partida() {
		
		lista_ficheros = ruta.list();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(lista_ficheros));
		comboBox.setBounds(109, 69, 215, 27);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Seleccione una Partida");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 37, 162, 21);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(65, 126, 304, 23);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(0, 0, 120, 23);
		panel.add(btnContinuar);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder nomFichero = new StringBuilder((String) comboBox.getSelectedItem());

				for (int i = 0; i < 4; i++) {
					nomFichero = nomFichero.deleteCharAt(nomFichero.length() - 1); // Eliminamos el ".dat" al final del fichero
				}

				Ventana_Juego frame = new Ventana_Juego(nomFichero.toString());
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		JButton btnBorrarPartida = new JButton("Borrar partida");
		btnBorrarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pop_up popup_frame = new pop_up((String) comboBox.getSelectedItem());
				popup_frame.setVisible(true);
				popup_frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnBorrarPartida.setBounds(184, 0, 120, 23);
		panel.add(btnBorrarPartida);
	}
}

// Creamos la ventana de confirmación para poder borrar un fichero de partida

class pop_up extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public pop_up(String fichero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u00BFEst\u00E1s segur@ de que quieres borrar esta partida?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(13, 16, 327, 34);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(26, 66, 302, 23);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Si, estoy seguro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Llamamos a la función borrar partida para eliminar el fichero indicado
				Eliminar_partida.borrar_partida("../partidas/" + fichero);
				JFrame jFrame = new JFrame();
				dispose();
				JOptionPane.showMessageDialog(jFrame, "La partida " + fichero + " se borró correctamente");
				Ventana_Menu_Inicio frame = new Ventana_Menu_Inicio();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

			}
		});
		btnNewButton.setBounds(0, 0, 128, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Mejor no");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana_Menu_Inicio frame = new Ventana_Menu_Inicio();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(174, 0, 128, 23);
		panel.add(btnNewButton_1);
	}

}