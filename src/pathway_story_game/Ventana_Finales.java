package pathway_story_game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Ventana_Finales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] lista_ficheros;
	private File ruta = new File("../partidas");
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ventana_Finales frame = new Ventana_Finales();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Ventana_Finales() {

		lista_ficheros = ruta.list();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(74, 13, 286, 32);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecciona  la partida");
		lblNewLabel.setBounds(0, 0, 135, 32);
		panel.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.setBounds(139, 5, 147, 22);
		comboBox.setModel(new DefaultComboBoxModel(lista_ficheros));
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setBounds(10, 58, 414, 194);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(81, 265, 271, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnVerFinales = new JButton("Ver Finales");
		btnVerFinales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String partida_selecc = comboBox.getSelectedItem().toString();

				try {

					Partida p;

					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream("../partidas/" + partida_selecc));
					p = (Partida) ois.readObject();
					
					ArrayList<Historia> historias_realizadas =  p.getHistorias()  ;
					TreeSet<String> finales_descubiertos = new TreeSet<String>() ;
					
					// Bucle for each
					String texto_text_area = " Finales descubiertos: " + "\n\n" ;
					int numFinalesDescubiertos = 0;
					for (Historia h: historias_realizadas) { 
						ArrayList<Nodo> nodos = h.getNodos_visitados();						
						finales_descubiertos.add(dimeTituloFinal(nodos.get(nodos.size()-1), nodos.get(nodos.size()-1).getTransporte()));
					}
					
					for(String s:finales_descubiertos) {
						numFinalesDescubiertos++ ;
						texto_text_area = texto_text_area + s.toString()+ "\n";
						textArea.setText(texto_text_area) ;
					}
					
					if (numFinalesDescubiertos == 1) {
						texto_text_area += "\n************************\n\n Has descubierto " + numFinalesDescubiertos + " final de los 13 que hay." ;
					}else if(numFinalesDescubiertos == 13) {						
						texto_text_area += "\n************************\n\n Enhorabuena has descubierto los 13 finales posibles." ;						
					}else {
						texto_text_area += "\n************************\n\n Has descubierto " + numFinalesDescubiertos + " finales de los 13 que hay." ;						
					}
					
					textArea.setText(texto_text_area) ;
					
					ois.close();

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		btnVerFinales.setBounds(0, 0, 112, 23);
		panel_1.add(btnVerFinales);

		JButton btnCerrar = new JButton("Salir");
		btnCerrar.setBounds(159, 0, 112, 23);
		panel_1.add(btnCerrar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Menu_Inicio frame = new Ventana_Menu_Inicio();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		
	
	}
	
	public String dimeTituloFinal(Nodo node, String transporte) {

		String tituloFinal ="";
		String id = node.getNode_id();
		
		switch (id) {
		case "A2":
			tituloFinal = " Final A2: Te han pillado en la aduana." ;
			break;
		case "Y1":
			tituloFinal = " Final Y1: Muerte por comer queso." ;
			break;
		case "Y2":
			tituloFinal = " Final Y2: Muerte por comer uvas." ;
			break;
		case "Y3":
			tituloFinal = " Final Y3: Muerte por beber vino." ;
			break;
		case "Y4":
			tituloFinal = " Final Y4: Te caiste en la ducha y te mataste." ;
			break;
		case "Y5":
			tituloFinal = " Final Y5: Has muerto de inanición." ;
			break;
		case "E2":
			tituloFinal = " Final E2: Te volviste loco, te mató la policia." ;
			break;
		case "H1":
			if (transporte == "barco") {				
				tituloFinal = " Final H1: Saliste del barco y fuiste por el bosque." ;
			}else {				
				tituloFinal = " Final H1: Saliste del tren y escapaste por el bosque." ;
			}
			break;
		case "H2":
			if (transporte == "barco") {				
				tituloFinal = " Final H1: Saliste del barco y escapaste por la ciudad." ;
			}else {				
				tituloFinal = " Final H1: Saliste del tren y te pillaron en la ciudad." ;
			}
			break;
		case "I1":
			tituloFinal = " Final I1: Intentaste suicidarte, pero escapaste." ;
			break;
		case "I2":
			tituloFinal = " Final I2: Te has entregado a la policía." ;
			break;
		case "I3":
			tituloFinal = " Final I3: Te escapaste con la mujer misteriosa." ;
			break;
		case "I4":
			tituloFinal = " Final I4: Todo fue un sueño, en realidad ya estas detenido." ;
			break;

		default:
			break;
		}
		
		return tituloFinal ;
		
	}
}
