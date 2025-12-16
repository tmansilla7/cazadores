package ar.edu.unlam.pb2;

public class ProfugoYaExistente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfugoYaExistente(String nombreProfugo) {
		super("El profugo "+nombreProfugo+" ya existe. ");
	}
	
}
