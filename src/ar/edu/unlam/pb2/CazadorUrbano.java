package ar.edu.unlam.pb2;

public class CazadorUrbano extends Cazador{

	public CazadorUrbano(String nombre, String zona, int experiencia) {
		super(nombre, zona, experiencia);
	}

	@Override
	public boolean puedeCapturar(Profugo p) {
		if(!p.isNervioso()) {
			return true;
		}
		return false;
	}
	
}