package ar.edu.unlam.pb2;

import java.util.Set;
import java.util.HashSet;

public class Operacion {

	private Set<Cazador> cazadores;
	private Set<Profugo> profugos;
	private Set<Zona> zonas;
	
	public Operacion() {
		cazadores = new HashSet<>();
		profugos = new HashSet<>();
		zonas = new HashSet<>();
	}

	public void agregarZona(Zona zonaAAgregar) throws ZonaYaExistente{
		for(Zona zona: zonas) {
			if(zona.equals(zonaAAgregar)) {
				throw new ZonaYaExistente(zonaAAgregar.getNombre());				
			}
		}
		zonas.add(zonaAAgregar);
	}
	
	public void agregarCazador(Cazador cazador) throws CazadorYaExistente {
		for(Cazador c: cazadores) {
			if(c.equals(cazador)) {
				throw new CazadorYaExistente(cazador.getNombre());
			}
		}
		cazadores.add(cazador);
	}

	public void agregarProfugo(Profugo profugo) throws ProfugoYaExistente {
		for(Profugo p: profugos) {
			if(p.equals(profugo)) {
				throw new ProfugoYaExistente(profugo.getNombre());
			}
		}
		profugos.add(profugo);
	}
	
	public boolean realizarCaptura(Cazador cazador) {
		boolean capturaRealizada = false;
		int valorMinimoDeHabilidadDelProfugoIntimidado = (int) Integer.MAX_VALUE;
		int experiencia = 0;
		
		for(Profugo p: profugos) {
			boolean puedeCapturar = cazador.getExperiencia() > p.getInocencia();
			
			if(p.getZona().equalsIgnoreCase(cazador.getZona())) {
				if(puedeCapturar && cazador.puedeCapturar(p) == true) {
					cazador.actualizarCantidadDeCapturas();
					p.profugoCapturado(cazador);
					capturaRealizada = true;
					System.out.println("El "+cazador.getNombre()+ " cazo al "+p.getNombre());
				}
				else {
					if(p.getHabilidad() < valorMinimoDeHabilidadDelProfugoIntimidado) {
						valorMinimoDeHabilidadDelProfugoIntimidado = p.getHabilidad();
					}
					cazador.noCapturo(p);
					p.profugoIntimidado();
				}
			}
		}
		
		experiencia = (valorMinimoDeHabilidadDelProfugoIntimidado) + (2 * cazador.getCantidadDeCapturasRealizadas());
		cazador.sumaDeExperienciaPostCaptura(experiencia);
		
		return capturaRealizada;
	}
	
	public boolean realizarCapturaConStreamsYLambdas(Cazador cazador) {
		boolean capturaRealizada = false;
		int valorMinimoDeHabilidadDelProfugoIntimidado = (int) Integer.MAX_VALUE;
		int experiencia = 0;
		
		profugos.stream()
        .filter(p -> p.getZona().equalsIgnoreCase(cazador.getZona()))
        .forEach(p -> {
            boolean puedeCapturar = cazador.getExperiencia() > p.getInocencia();
            
            if(puedeCapturar && cazador.puedeCapturar(p)) {
                p.profugoCapturado(cazador);
            } 
            else{
                cazador.noCapturo(p);
            }
        });
		
		experiencia = (valorMinimoDeHabilidadDelProfugoIntimidado) + (2 * cazador.getCantidadDeCapturasRealizadas());
		cazador.sumaDeExperienciaPostCaptura(experiencia);
		
		return capturaRealizada;
	}
	
	public Set<Profugo> getProfugosNoCapturados(){
		Set<Profugo> profugosCapturados = new HashSet<>();
		
		for(Profugo p:profugos) {
			if(!p.getEstadoDeCaptura()) {
				profugosCapturados.add(p);
			}
		}
		
		return profugosCapturados;
	}
	
	public Set<Profugo> getProfugosCapturados(){
		Set<Profugo> profugosCapturados = new HashSet<>();
		
		for(Profugo p:profugos) {
			if(p.getEstadoDeCaptura()) {
				profugosCapturados.add(p);
			}
		}
		
		return profugosCapturados;
	}
	
	public Profugo getProfugoMasHabilCapturado() {
		Profugo p = null;
		int habilidadActual = 0;
		
		for(Profugo profugo:profugos) {			
			if(profugo.getEstadoDeCaptura() && profugo.getHabilidad() > habilidadActual) {
				habilidadActual = profugo.getHabilidad();
				p = profugo;
			}
		}
		
		return p;
	}
	
	public Cazador getCazadorConMasCapturasRealizadas() {
		Cazador c = null;
		
		for(Cazador cazador:cazadores) {
			if(c == null || cazador.getCantidadDeCapturasRealizadas() > c.getCantidadDeCapturasRealizadas()) {
				c = cazador;
			}
		}
		
		return c;
	}

	public Set<Profugo> getProfugos() {
		return profugos;
	}
	
}