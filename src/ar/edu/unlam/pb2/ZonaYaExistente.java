package ar.edu.unlam.pb2;

public class ZonaYaExistente extends Exception {
	private static final long serialVersionUID = 1L;

	public ZonaYaExistente(String nombre) {
		super("La zona " +nombre+" ya existe.");
	}

}