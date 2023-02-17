package pathway_story_game;

import java.io.Serializable;

public class StoryTree {
	
	private Nodo root ;
	@SuppressWarnings("unused")
	private String pasaporte_elegido ; // La eleccion del pasaporte no sera parte de los nodos, por eso se añade desde fuera
	private String transporte; // La eleccion del transporte no sera parte de los nodos, por eso se añade desde fuera
	public StoryTree(String pasaporte_elegido, String transporte) {
		
		this.pasaporte_elegido = pasaporte_elegido; 
		this.transporte = transporte; 
		
		Nodo root = new Nodo("root","Has elegido ir en "+transporte+", procedes a ir al check-in.","/assets/aduana.png",null,null);  // Creamos el nodo padre de toda la historia (el primer nodo de todos)
		
		this.root = root ;
		
		
		String[] opciones_A1 = {"Esconderse","Disfrutar"};
		Nodo A1 = new Nodo("A1","Has pasado el check-in y vas a tu camarote, ha llegado el momento de decidir como vas a actuar ahora,\n ¿Te escondes o disfrutas de la estancia?","/assets/compartimento_"+transporte+".png",opciones_A1,transporte);
		String[] opciones_A2 = {"Finalizar"};
		Nodo A2 = new Nodo("A2", "Al ser un fugitivo nacional te han detenido en la aduana. \nEl pasaporte que elegiste no se parecía lo suficiente al tuyo. ","/assets/gameover_carcel.png",opciones_A2,transporte);     
		
		root.setHijo_izq(A1);
		root.setHijo_der(A2);
		A1.setPadre(root);
		A2.setPadre(root);
		
		
		
		
		// - - - - - - - - - - - - - - - - - - - RAMA ESCONDERTE - - - - - - - - - - - - - - - - - - - - - - -
		
		
		
		
		String[] opciones_B1 = {"Salir","Quedarte"};
		Nodo B1 = new Nodo("B1","Has decidido esconderte.\nAl estar en tu habitación has escuchado un grito fuera.\n¿Te asomas al pasillo a ver que ha pasado o sigues en la habitación escondido?","/assets/compartimento_"+transporte+".png",opciones_B1,transporte);
		String[] opciones_B2 = {"Continuar"};
		Nodo B2 = new Nodo("B2", "Has elegido disfrutar de la estancia y al mirar en tu habitación has visto este bodegón preparado para tí","/assets/bodegon.png",opciones_B2,transporte);     
		
		A1.setHijo_izq(B1);
		A1.setHijo_der(B2);
		B1.setPadre(A1);
		B2.setPadre(A1);
		
		
		
		
		
		String[] opciones_C1 = {"Continuar"};
		Nodo C1 = new Nodo("C1","Al salir al pasillo has visto que ya habían llegado unos policias.\nTe han dicho que por seguridad te quedes en tu habitación.\nAl rato llaman a la puerta para hablar contigo.\nHa habido un asesinato en el "+transporte+".","/assets/pasillo_"+transporte+"_policia.png",opciones_C1,transporte);
		String[] opciones_C2 = {"Continuar"};
		Nodo C2 = new Nodo("C2", "Alguien ha llamado a tu habitación.\nAl abrir han resultado ser 2 agentes de policia.\nHa habido un asesinato en el "+transporte+" y vienen a interrogarte","/assets/detectives_"+transporte+".png",opciones_C2,transporte);     
		
		B1.setHijo_izq(C1);
		B1.setHijo_der(C2);
		C1.setPadre(B1);
		C2.setPadre(B1);
		
		
		
		
		
		String[] opciones_D1 = {"Calmarte","Atacarles"};
		Nodo D1 = new Nodo("D1","Detectives: \"No entendemos porqué llevas tanto tiempo sin salir de tu habitación\"\nEs posible que te hayan descubierto.\n¿Te calmas y esperas a ver que pasa o les atacas e intentas escapar?","/assets/detectives_"+transporte+".png",opciones_D1,transporte);
		
		C2.setHijo_izq(D1);
		C2.setHijo_der(D1);
		D1.setPadre(C2);
		
		
		
		
			
		String[] opciones_E1 = {"Continuar"};
		Nodo E1 = new Nodo("E1","Detectives: \"Puedes quedarte tranquilo, ya hay una persona detenida,\nsolo estabamos buscando información para la investigación\".\nLos detectives no dudan de tí.","/assets/detectives_"+transporte+".png",opciones_E1,transporte);
		String[] opciones_E2 = {"Finalizar"};
		Nodo E2 = new Nodo("E2", "Has ido a atacarles, a la primera de cambio te han pegado un tiro y has muerto.","/assets/gameover_muerte.png",opciones_E2,transporte);     
		
		D1.setHijo_izq(E1);
		D1.setHijo_der(E2);
		E1.setPadre(C1);
		E2.setPadre(D1);
		C1.setHijo_izq(E1);
		C1.setHijo_der(E1);
		
		
		
		
		
		String[] opciones_F1 = {"Salir","Quedarte"};
		Nodo F1;
		if (transporte=="barco") {
			F1 = new Nodo("F1","Habeis hecho una escala en Marsella para sacar el cuerpo del asesinado.\nAhora tienes la posibilidad de salir del barco e intentar escapar.\n¿Qué vas a hacer? ¿Sales o te quedas?","/assets/"+transporte+"_parado.png",opciones_F1,transporte);
		}else {
			F1 = new Nodo("F1","Habeis hecho una parada en Zurich para sacar el cuerpo del asesinado.\nAhora tienes la posibilidad de salir del Tren e intentar escapar.\n¿Qué vas a hacer? ¿Sales o te quedas?","/assets/"+transporte+"_parado.png",opciones_F1,transporte);
		}	
		E1.setHijo_izq(F1);
		E1.setHijo_der(F1);
		F1.setPadre(E1);
		
		
									
		
		String[] opciones_G1 = {"Bosque","Ciudad"};
		Nodo G1;
		if (transporte=="barco") {
			G1 = new Nodo("G1","Has decidido salir del barco y continuar tu camino fuera.\nAhora tienes que decidir si huir hacía el centro de la ciudad o intentar huir por el bosque que hay \na las afueras.","/assets/"+transporte+"_parado.png",opciones_G1,transporte);
		}else {
			G1 = new Nodo("G1","Has decidido salir del tren y continuar tu camino fuera.\nAhora tienes que decidir si huir hacía el centro de la ciudad o intentar huir por el bosque que hay \na las afueras.","/assets/"+transporte+"_parado.png",opciones_G1,transporte);
		}	
		String[] opciones_G2 = {"Continuar"};
		Nodo G2;
		if (transporte=="barco") {
			G2 =new Nodo("G2","Te has quedado en el barco y este ha reanudado su marcha","/assets/"+transporte+"_en_marcha.png",opciones_G2,transporte);
		}else {
			G2 =new Nodo("G2","Te has quedado en el tren y este ha reanudado su marcha","/assets/"+transporte+"_en_marcha.png",opciones_G2,transporte);
		}	
		
		F1.setHijo_izq(G1);
		F1.setHijo_der(G2);
		G1.setPadre(F1);
		G2.setPadre(F1);
		
		
		
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RAMA SALIR - - - - - - - - - - - - - - - - - - - - - - -

		
		
		// Nodo que hace referencia a la decisión de ir al bosque
		
		
		Nodo H1;
		if (transporte=="barco") {
			String[] opciones_H1 = {"Suicidarte","Entregarte"};
			H1 = new Nodo("H1","Has decidido ir en dirección al bosque y ha sido una mala idea.\nDespués de huir durante un rato has llegado un acantilado sin salida.\nTe están pisando los talones ¿Que vas a hacer ahora?","/assets/bosque_marsella.png",opciones_H1,transporte);
		}else {
			String[] opciones_H1 = {"Finalizar"};
			H1 = new Nodo("H1","Has decidido ir en dirección al bosque y ha sido una buena idea.\nEste bosque tan frondoso te ha permitido esconderte hasta que has podido huir.","/assets/bosque_zurich.png",opciones_H1,transporte);
		}	
		
		
		// Nodo que hace referencia a la decisión de ir a la ciudad
		
		
		Nodo H2;
		if (transporte=="barco") {
			String[] opciones_H2 = {"Finalizar"};
			H2 =new Nodo("H2","Has decidido ir en dirección a la ciudad y ha sido una buena idea.\nEsta ciudad tan llena de gente te ha permitido escabullirte hasta que has podido huir.","/assets/ciudad_marsella.png",opciones_H2,transporte);
		}else {
			String[] opciones_H2 = {"Continuar"};
			H2 =new Nodo("H2","Has decidido ir en dirección a la ciudad y ha sido una mala idea.\nDespués de que te persiguieran durante un rato has llegado un callejón sin salida.\nTe están pisando los talones","/assets/ciudad_zurich.png",opciones_H2,transporte);
		}	
		
		G1.setHijo_izq(H1);
		G1.setHijo_der(H2);
		H1.setPadre(G1);
		H2.setPadre(G1);
		
		
		
		
		
		Nodo I1;
		if (transporte=="barco") {
			String[] opciones_I1 = {"Finalizar"};
			I1 =new Nodo("I1","Al saltar del acantilado para suicidarte has caido al agua.\nHas sobrevivido a la caida y has podido huir.","/assets/bosque_marsella.png",opciones_I1,transporte);
		}else {
			String[] opciones_I1 = {"Finalizar"};
			I1 =new Nodo("I1","Al saltar del acantilado para suicidarte has caido al agua.\nHas sobrevivido a la caida y has podido huir.","/assets/bosque_marsella.png",opciones_I1,transporte);
		
		}	
		
		Nodo I2;
		String[] opciones_I2 = {"Finalizar"};
		I2 =new Nodo("I2","Te has entregado a las autoridades y ha sido imposible huir.\nTe han pillado.","/assets/gameover_carcel.png",opciones_I2,transporte);
		
		
		H1.setHijo_izq(I1);
		H1.setHijo_der(I2);
		H2.setHijo_der(I2);
		H2.setHijo_izq(I2);
		I1.setPadre(H1);
		I2.setPadre(H1);
		
		
		
		
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RAMA QUEDARTE - - - - - - - - - - - - - - - - - - - - - - -
						
		
		
		
		Nodo H3;
		if (transporte=="barco") {
			String[] opciones_H3 = {"Cenar con ella","Irte"};
			H3 = new Nodo("H3","El barco ha reanudado su marcha.\nHas salido a cenar y una mujer se ha interesado en cenar contigo.\nAhora que estás solo es tu momento de decidir si irte o cenar con ella","/assets/mujer_"+transporte+".png",opciones_H3,transporte);
		}else {
			String[] opciones_H3 = {"Cenar con ella","Irte"};
			H3 = new Nodo("H3","El tren ha reanudado su marcha.\nHas salido a cenar y una mujer se ha interesado en cenar contigo.\nAhora que estás solo es tu momento de decidir si irte o cenar con ella","/assets/mujer_"+transporte+".png",opciones_H3,transporte);
		}
		
		G2.setHijo_izq(H3);
		G2.setHijo_der(H3);
		H3.setPadre(G2);
		
		
		
		
		String[] opciones_I3 = {"Finalizar"};
		Nodo I3 = new Nodo("I3","Has cenado con la mujer, ha resultado ser policia pero el feeling que habeis tenido le ha hecho ayudarte.\nOs habeis fugado juntos.","/assets/mujer_"+transporte+".png",opciones_I3,transporte); // Logro los serrano
		String[] opciones_I4 = {"Finalizar"};
		Nodo I4= new Nodo("I4", "Te has ido a tu habitación, te has acostado y cuando te has despertado\nya estabas detenido, todo había sido un sueño.","/assets/gameover_carcel.png",opciones_I4,transporte); 
		H3.setHijo_izq(I3);
		H3.setHijo_der(I4);
		I3.setPadre(H3);
		I4.setPadre(H3);
		
		
		
		// - - - - - - - - - - - - - - - - - - - RAMA DISFRUTAR - - - - - - - - - - - - - - - - - - - - - - -
		
		
		
		
		String[] opciones_X1 = {"Si","No"};
		Nodo X1 = new Nodo("X1","¿Quieres comer el Queso que hay en el lote?","/assets/bodegon_queso.png",opciones_X1,transporte);
		
		B2.setHijo_izq(X1);
		B2.setHijo_der(X1);
		X1.setPadre(B2);
		
		
		
		String[] opciones_Y1 = {"Finalizar"};
		Nodo Y1 = new Nodo("Y1","Has comido el queso pero eras intolerante a la lactosa.\nTe ha sentado tan mal que han encontrado tu cuerpo sin vida a la mañana siguiente.\n","/assets/gameover_muerte.png",opciones_Y1,transporte);
		String[] opciones_X2 = {"Si","No"};
		Nodo X2 = new Nodo("X2", "¿Quieres comer uvas?","/assets/bodegon_uvas.png",opciones_X2,transporte);     
		
		X1.setHijo_izq(Y1);
		X1.setHijo_der(X2);
		Y1.setPadre(X1);
		X2.setPadre(X1);
		
		
		
		String[] opciones_Y2 = {"Finalizar"};
		Nodo Y2 = new Nodo("Y2","Has lanzado una uva al aire para cogerla con la boca.\nCuando la has cogido te has atragantado y te has ahogado solo en tu habitación.\n","/assets/gameover_muerte.png",opciones_Y2,transporte);
		String[] opciones_X3 = {"Si","No"};
		Nodo X3 = new Nodo("X3", "¿Quieres beber vino?","/assets/bodegon_vino.png",opciones_X3,transporte);     
		
		X2.setHijo_izq(Y2);
		X2.setHijo_der(X3);
		Y2.setPadre(X2);
		X3.setPadre(X2);
		
		
		
		
		String[] opciones_Y3 = {"Finalizar"};
		Nodo Y3 = new Nodo("Y3","Has bebido vino hasta quedar inconsciente.\n¡Has muerto de un coma etílico borracho!","/assets/gameover_muerte.png",opciones_Y3,transporte);
		String[] opciones_X4 = {"Si","No"};
		Nodo X4 = new Nodo("X4", "Viendo que no quieres nada de tu bodegón, ¿Quieres darte una relajante ducha?","/assets/baño_"+transporte+".png",opciones_X4,transporte);     
		
		X3.setHijo_izq(Y3);
		X3.setHijo_der(X4);
		Y3.setPadre(X3);
		X4.setPadre(X3);
		
		
		
		
		String[] opciones_Y4 = {"Finalizar"};
		Nodo Y4 = new Nodo("Y4","Estabas duchándote y te has resvalado.\nAl caer te has golpeado la cabeza y has muerto.","/assets/gameover_muerte.png",opciones_Y4,transporte);
		String[] opciones_Y5 = {"Finalizar"};
		Nodo Y5= new Nodo("Y5", "Has muerto de inanición por no haber comido en todo el día.\nEncima has muerto siendo un guarro.","/assets/gameover_muerte.png",opciones_Y5,transporte);     
		
		X4.setHijo_izq(Y4);
		X4.setHijo_der(Y5);
		Y4.setPadre(X4);
		Y5.setPadre(X4);
		
		
		
		

	
	}

	public Nodo getRoot() {
		return this.root;
	}

	public String getTransporte() {
		return transporte;
	}
	
	
	
	
}

class Nodo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String node_id ;
	private String texto ;
	private String url_image ;
	private Nodo padre ;
	private Nodo hijo_izq ; // Referencia a los hijos de cada nodo, de esta manera creamos las relaciones entre los nodos y la estructura de datos
	private Nodo hijo_der ;
	private String[] opciones ;
	private String transporte ;
	

	public Nodo(String node_id, String texto, String url_image, String[] opciones, String transporte) {
		
		this.opciones = opciones ;
		this.node_id = node_id;
		this.texto = texto ;
		this.url_image = url_image ;
		this.transporte = transporte ;
	
	}

	public String[] getOpciones() {
		return opciones;
	}
	
	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public Nodo getHijo_izq() {
		return hijo_izq;
	}

	public void setHijo_izq(Nodo hijo_izq) {
		this.hijo_izq = hijo_izq;
	}

	public Nodo getHijo_der() {
		return hijo_der;
	}

	public void setHijo_der(Nodo hijo_der) {
		this.hijo_der = hijo_der;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	public String getTransporte() {
		return transporte;
	}
	
	
	
}
