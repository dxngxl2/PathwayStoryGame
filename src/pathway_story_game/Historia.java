package pathway_story_game;

import java.io.Serializable;
import java.util.ArrayList;

public class Historia implements Serializable {

	private static final long serialVersionUID = -1067241578363096933L;
	private ArrayList<Nodo> nodos_visitados;

	public Historia() {
		nodos_visitados = new ArrayList<Nodo>();
	}

	public ArrayList<Nodo> getNodos_visitados() {
		return nodos_visitados;
	}


	public void addNodoVisitado(Nodo nodo) {
		nodos_visitados.add(nodo);
	}

	
	

}
