package ar.edu.unlam.pb2;

public class CazadorYaExistente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CazadorYaExistente(String nombreCazador) {
		super("El cazador "+nombreCazador+ " ya existe. ");
	}

}
