package ar.edu.unlam.pb2;

import java.util.Objects;
import java.util.Set;

public class Zona {
	
	private static int contadorIds = 0;
    private int id;
    private String nombre;

    public Zona(String nombre) {
        this.id = ++contadorIds;
        this.nombre = nombre;
    }

	public String getNombre() {
		return nombre;
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
		Zona other = (Zona) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
}