package pathway_story_game;

import java.io.File;

public class Eliminar_partida {

	public static void borrar_partida(String ruta) {
		File archivo = new File(ruta);
		archivo.delete();
	}
}
