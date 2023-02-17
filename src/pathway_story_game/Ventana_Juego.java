package pathway_story_game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ventana_Juego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private StoryTree storyTree;
	private Nodo nodo_actual;
	private final int PASAPORTE_0 = 0;
	private final int PASAPORTE_1 = 1;
	private final int PASAPORTE_2 = 2;
	private final int PASAPORTE_3 = 3;
	private final int PASAPORTE_4 = 4;
	private final int BILLETE_1 = 5;
	private final int BILLETE_2 = 6;
	private final int BARCO = 1;
	private JLabel imagen = DefaultComponentFactory.getInstance().createLabel("");
	private int focused = 0;
	private JTextArea texto = new JTextArea();
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox = new JComboBox();
	private int opcion_pasaporte = -1;
	private int opcion_transporte = -1;
	private int estado_continuar = 0;
	private Partida partida_actual;
	private Historia nueva_historia;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ventana_Juego frame = new Ventana_Juego(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Ventana_Juego(String fichero) {

		nueva_historia = new Historia(); // Creo un nuevo objeto historia

		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 19, 704, 469);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btn_alante = new JButton(">");
		btn_alante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (focused) {

				case PASAPORTE_0:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_2.png")));
					texto.setText("Este es el pasaporte falso nº 1");
					comboBox.setSelectedIndex(0);

					focused = 1;

					break;
				case PASAPORTE_1:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_3.png")));
					texto.setText("Este es el pasaporte falso nº 2");
					comboBox.setSelectedIndex(1);

					focused = 2;

					break;
				case PASAPORTE_2:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_4.png")));
					texto.setText("Este es el pasaporte falso nº 3");
					comboBox.setSelectedIndex(2);

					focused = 3;

					break;
				case PASAPORTE_3:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_5.png")));
					texto.setText("Este es el pasaporte falso nº 4");
					comboBox.setSelectedIndex(3);

					focused = 4;

					break;

				case PASAPORTE_4:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_1.png")));
					texto.setText(
							"Este es tu pasaporte, si quieres buscar un nuevo futuro deberás elegir uno de los siguientes. \nToma bien tu decisión, de ella dependerá tu destino.\nSuerte.");

					focused = 0;

					break;
				case BILLETE_1:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/billete_tren.png")));
					comboBox.setSelectedIndex(1);

					focused = 6;

					break;
				case BILLETE_2:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/billete_barco.png")));
					comboBox.setSelectedIndex(0);

					focused = 5;

					break;

				default:

					break;
				}

			}
		});
		btn_alante.setBounds(575, 220, 62, 29);
		panel.add(btn_alante);

		JButton btn_atras = new JButton("<");
		btn_atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (focused) {

				case PASAPORTE_0:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_5.png")));
					texto.setText("Este es el pasaporte falso nº 4");
					comboBox.setSelectedIndex(3);

					focused = 4;

					break;
				case PASAPORTE_1:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_1.png")));
					texto.setText(
							"Este es tu pasaporte, si quieres buscar un nuevo futuro deberás elegir uno de los siguientes. \nDecide bien tu elección, de ella dependerá tu destino.\nSuerte.");

					focused = 0;

					break;
				case PASAPORTE_2:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_2.png")));
					texto.setText("Este es el pasaporte falso nº 1");
					comboBox.setSelectedIndex(0);

					focused = 1;

					break;
				case PASAPORTE_3:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_3.png")));
					texto.setText("Este es el pasaporte falso nº 2");
					comboBox.setSelectedIndex(1);

					focused = 2;

					break;
				case PASAPORTE_4:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_4.png")));
					texto.setText("Este es el pasaporte falso nº 3");
					comboBox.setSelectedIndex(2);

					focused = 3;

					break;

				case BILLETE_1:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/billete_tren.png")));
					comboBox.setSelectedIndex(1);

					focused = 6;

					break;
				case BILLETE_2:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/billete_barco.png")));
					comboBox.setSelectedIndex(0);

					focused = 5;

					break;

				default:

					break;
				}

			}
		});
		btn_atras.setBounds(70, 220, 62, 29);
		panel.add(btn_atras);

		imagen.setBounds(0, 0, 704, 469);
		panel.add(imagen);
		imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/pasaporte_1.png")));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(15, 510, 704, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		texto.setEditable(false);

		texto.setText(
				"Eres un fugitivo de la justicia de tu pais y este es tu pasaporte.\nSi quieres escapar y buscar un nuevo futuro deberás elegir una de las siguientes falsificaciones. \nToma bien tu decisión, de ella dependerá tu destino.\nSuerte.");
		texto.setBounds(6, 6, 692, 67);
		panel_1.add(texto);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setBounds(15, 613, 215, 27);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Pasaporte 1", "Pasaporte 2", "Pasaporte 3", "Pasaporte 4" }));
		comboBox.setBounds(67, 0, 142, 27);
		panel_2.add(comboBox);

		JLabel lblNewLabel = new JLabel("Opción");
		lblNewLabel.setBounds(6, 5, 177, 16);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (estado_continuar) {

				case 0:

					panel.add(imagen);
					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource("/assets/billete_barco.png")));
					btn_atras.setBounds(70, 415, 62, 29);
					btn_alante.setBounds(575, 415, 62, 29);
					opcion_pasaporte = comboBox.getSelectedIndex() + 1;
					comboBox.setModel(new DefaultComboBoxModel(new String[] { "Barco", "Tren" }));
					texto.setText(
							"Tienes dos opciones para continuar con tu viaje: \n 1. Viajar en barco a Nápoles \n 2. Viajar en tren a Berlín");
					focused = 5;

					estado_continuar = 1;

					break;

				case 1:

					panel.add(imagen);
					btn_atras.setVisible(false);
					btn_alante.setVisible(false);
					comboBox.setEnabled(false);
					opcion_transporte = comboBox.getSelectedIndex() + 1;

					String trans_elec = (opcion_transporte == BARCO) ? "barco" : "tren"; // OPERADOR TERNARIO

					// esto es lo mismo que "String trans_elec = (opcion_transporte == 1)?"barco":"tren";

					storyTree = new StoryTree("pasaporte " + opcion_pasaporte, trans_elec);

					nodo_actual = storyTree.getRoot();

					nueva_historia.addNodoVisitado(nodo_actual); // Añadimos el nodo a nuestra historia que luego serializaremos en el fichero partida
																			
																				

					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource(nodo_actual.getUrl_image())));
					texto.setText(nodo_actual.getTexto());

					estado_continuar = 2;

					break;

				case 2:

					panel.add(imagen);
					comboBox.setEnabled(true);

					if (opcion_pasaporte == PASAPORTE_1 || opcion_pasaporte == 2) {
						nodo_actual = nodo_actual.getHijo_izq();
					} else {
						nodo_actual = nodo_actual.getHijo_der();
					}

					nueva_historia.addNodoVisitado(nodo_actual); // Añadimos el nodo a nuestra historia que luego serializaremos en el ficheropartida
																				
																				

					imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource(nodo_actual.getUrl_image())));
					comboBox.setModel(new DefaultComboBoxModel(nodo_actual.getOpciones()));
					texto.setText(nodo_actual.getTexto());

					estado_continuar = 3;

					break;

				default:

					panel.add(imagen);
					comboBox.setEnabled(true);
					int opcion_elegida = comboBox.getSelectedIndex();

					// Con este if else definimos la circunstancia en la que acaba el juego y se
					// cierra la ventana de la partida
					if (nodo_actual.getOpciones()[0] == "Finalizar") {

						ObjectInputStream ois;
						ObjectOutputStream oos;
						// este bloque inicializa los output e input streams para utilizarlos mas
						// adelante
						try {
							ois = new ObjectInputStream(new FileInputStream("../partidas/" + fichero + ".dat"));
							partida_actual = (Partida) ois.readObject(); // Creo el objeto de la partida actual a partir
																			// del objeto partida que se genera en la
																			// ventana "Ventana_crear_partida"
							ois.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						partida_actual.addHistoria(nueva_historia);

						Eliminar_partida.borrar_partida(fichero); // Se utiliza un metodo estático para poder
																	// referenciarlo sin tener que crear un objeto

						try {
							oos = new ObjectOutputStream(new FileOutputStream("../partidas/" + fichero + ".dat"));
							oos.writeObject(partida_actual);
							oos.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						Ventana_Menu_Inicio frame = new Ventana_Menu_Inicio();
						comboBox.setModel(new DefaultComboBoxModel(new String[] { "Continuar" }));
						texto.setText(nodo_actual.getTexto());
						comboBox.setEnabled(false);
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						dispose();

					} else {

						// Con este if else definimos si al pulsar el botón de Continuar iremos hacia el
						// camino de la izquierda o el de la derecha
						if (opcion_elegida == 0) {
							nodo_actual = nodo_actual.getHijo_izq();
						} else {
							nodo_actual = nodo_actual.getHijo_der();
						}

						nueva_historia.addNodoVisitado(nodo_actual);// Añadimos el nodo a nuestra historia
																					// que luego serializaremos en el
																					// fichero partida

						// Con este if else definimos si la ventana tiene decisiones que tomar o no. Si
						// solo tenemos una opción posible en nuestro nodo el combo box quedará
						// bloqueado.
						if (nodo_actual.getOpciones().length == 2) {
							comboBox.setModel(new DefaultComboBoxModel(
									new String[] { nodo_actual.getOpciones()[0], nodo_actual.getOpciones()[1] }));
						} else {
							comboBox.setModel(new DefaultComboBoxModel(new String[] { nodo_actual.getOpciones()[0] }));
							comboBox.setEnabled(false);
						}

						// Definimos la imagen de nuestra ventana dependiendo del nodo hacia el que
						// hayamos ido
						imagen.setIcon(new ImageIcon(Ventana_Juego.class.getResource(nodo_actual.getUrl_image())));

						// Definimos el texto de nuestra ventana dependiendo del nodo hacia el que
						// hayamos ido
						texto.setText(nodo_actual.getTexto());

					}
					break;

				}

			}
		});
		btnContinuar.setBounds(308, 611, 117, 29);
		contentPane.add(btnContinuar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Menu_Inicio frame = new Ventana_Menu_Inicio();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose() ;

			}
		});
		btnSalir.setBounds(602, 611, 117, 29);
		contentPane.add(btnSalir);

	}
	
	
	public void cerrarVentana() {
		dispose() ;
	}
}


