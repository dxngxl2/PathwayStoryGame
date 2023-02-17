package pathway_story_game;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable {

	private static final long serialVersionUID = 93255891115285188L;
	
	private String id_partida;
	private ArrayList<Historia> historias;

	public Partida(String id_partida) {
		this.id_partida = id_partida;
		this.historias = new ArrayList<Historia>();
	}

	public String getId_partida() {
		return id_partida;
	}

	public ArrayList<Historia> getHistorias() {
		return historias;
	}
	
	
	public void addHistoria(Historia historia) {
		historias.add(historia);
	}
	
}

