package ar.edu.unlam.pb2;

public class CazadorSigiloso extends Cazador{

	public CazadorSigiloso(String nombre, String zona, int experiencia) {
		super(nombre, zona, experiencia);
	}
	
	@Override
	public boolean puedeCapturar(Profugo p) {
		if(p.getHabilidad() < 50) {
			return true;
		}
		return false;
	}
	
	@Override
	public void noCapturo(Profugo p) {
		p.reduccionDeHabilidad();
	}

}