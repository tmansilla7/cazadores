package ar.edu.unlam.pb2;

abstract public class Cazador {
	
	private String nombre;
	private String zona;
	private int experiencia;
	private int cantidadDeCapturasRealizadas;
	
	public Cazador(String nombre, String zona, int experiencia) {
		this.nombre = nombre;
		this.zona = zona;
		this.experiencia = experiencia;
		this.cantidadDeCapturasRealizadas = 0;
	}
	
	public void sumaDeExperienciaPostCaptura(int num) {
		this.experiencia += num;
	}
	
	public abstract boolean puedeCapturar(Profugo profugo);

	public void noCapturo(Profugo p) {
		p.cambiarEstadoNervioso();
	}
	
	public void actualizarCantidadDeCapturas() {
		cantidadDeCapturasRealizadas++;
	}
	
	public int getCantidadDeCapturasRealizadas() {
		return cantidadDeCapturasRealizadas;
	}

	public String getNombre() {
		return nombre;
	}

	public String getZona() {
		return zona;
	}

	public int getExperiencia() {
		return experiencia;
	}

	@Override
	public String toString() {
		return "Cazador [nombre=" + nombre + ", zona=" + zona + ", experiencia=" + experiencia
				+ ", cantidadDeCapturasRealizadas=" + cantidadDeCapturasRealizadas + "]";
	}
	
}