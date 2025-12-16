package ar.edu.unlam.pb2;

import java.util.Objects;

public class Profugo implements Evolucion{
	
	private String zona;
	private String nombre;
	private int inocencia;
	private int habilidad;
	private boolean nervioso;
	private boolean capturado;
	private Cazador cazador;
	
	public Profugo(String nombre, String zona, int inocencia, int habilidad, boolean nervioso) {
		this.nombre = nombre;
		this.zona = zona;
		this.inocencia = inocencia;
		this.habilidad = habilidad;
		this.nervioso = nervioso;
		this.capturado = false;
		this.cazador = null;
	}
	
	public void profugoCapturado(Cazador cazador) {
		this.capturado = true;
		this.cazador = cazador;
	}
	
	public void profugoIntimidado() {
		if(inocencia > 2) {
			this.inocencia -= 2;			
		}
	}
	
	public void cambiarEstadoNervioso() {
		if(nervioso) {
			nervioso = false;
		}
		else {
			nervioso = true;
		}
	}

	public void reduccionDeHabilidad() {
		if(habilidad >= 5) {
			habilidad -= 5;
		}
	}
	
	public boolean getEstadoDeCaptura() {
		return this.capturado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getZona() {
		return zona;
	}

	public int getInocencia() {
		return inocencia;
	}

	public int getHabilidad() {
		return habilidad;
	}

	public boolean isNervioso() {
		return nervioso;
	}

	@Override
	public void artesMarcialesAvanzadas() throws NivelMaximoDeHabilidadSuperado{
		if(habilidad*2 <= 100) {
			this.habilidad *= 2;
		}
//		else {
//			throw new NivelMaximoDeHabilidadSuperado();			
//		}
	}

	@Override
	public void entrenamientoDeElite() {
		this.nervioso = false;
	}

	@Override
	public void proteccionLegal() throws InocenciaMinimaAlcanzada{
		int nuevaInocencia = 0;
		
		if(inocencia < 40) {
			nuevaInocencia = (int)(Math.random()*41+60);
			this.inocencia = nuevaInocencia;
		}
//		else {
//			throw new InocenciaMinimaAlcanzada();
//		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profugo other = (Profugo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Profugo [zona=" + zona + ", nombre=" + nombre + ", inocencia=" + inocencia + ", habilidad=" + habilidad
				+ ", nervioso=" + nervioso + ", capturado=" + capturado + ", cazador=" + cazador + "]";
	}


}