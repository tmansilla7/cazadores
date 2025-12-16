package ar.edu.unlam.pb2;

import static org.junit.Assert.*;
import org.junit.Before;
import java.util.Set;
import java.util.HashSet;

public class Test {
	
	private Operacion operacion;
	
	private Cazador cazador1;
	private Cazador cazador2;
	private Cazador cazador3;
	private Cazador cazador4;
	private Cazador cazador5;
	private Cazador cazador6;
	
	private Profugo profugo1;
	private Profugo profugo2;
	private Profugo profugo3;
	private Profugo profugo4;
	private Profugo profugo5;
	private Profugo profugo6;
	
	private Zona zona1;
	private Zona zona2;
	
	@Before
	public void setUp() throws ZonaYaExistente {
		operacion = new Operacion();

		zona1 = new Zona("Zona 1");
		zona2 = new Zona("Zona 2");

		operacion.agregarZona(zona1);			
		operacion.agregarZona(zona2);		
		
		cazador1 = new CazadorRural("Cazador 1", zona1.getNombre(), 50);
		cazador2 = new CazadorSigiloso("Cazador 2", zona1.getNombre(), 25);
		cazador3 = new CazadorUrbano("Cazador 3", zona1.getNombre(), 100);
		
		cazador4 = new CazadorRural("Cazador 4", zona2.getNombre(), 50);
		cazador5 = new CazadorSigiloso("Cazador 5", zona2.getNombre(), 25);
		cazador6 = new CazadorUrbano("Cazador 6", zona2.getNombre(), 100);
		
		profugo1 = new Profugo("Profugo 1", zona1.getNombre(), 25, 25, true);
		profugo2 = new Profugo("Profugo 2", zona1.getNombre(), 100, 100, false);
		profugo3 = new Profugo("Profugo 3", zona1.getNombre(), 50, 50, true);
		profugo4 = new Profugo("Profugo 4", zona2.getNombre(), 25, 25, false);
		profugo5 = new Profugo("Profugo 5", zona2.getNombre(), 100, 100, true);
		profugo6 = new Profugo("Profugo 6", zona2.getNombre(), 50, 50, false);
		

		try {
			operacion.agregarZona(zona1);
		} catch(ZonaYaExistente zye) {
			zye.getMessage();
		}

		try {
			operacion.agregarCazador(cazador1);					
			operacion.agregarCazador(cazador2);					
			operacion.agregarCazador(cazador3);					
			operacion.agregarCazador(cazador4);					
			operacion.agregarCazador(cazador5);					
			operacion.agregarCazador(cazador6);					
			operacion.agregarCazador(cazador6);					
		} catch(CazadorYaExistente zye) {
			zye.getMessage();
		}
		
		try {
			operacion.agregarProfugo(profugo1);					
			operacion.agregarProfugo(profugo2);					
			operacion.agregarProfugo(profugo3);					
			operacion.agregarProfugo(profugo4);						
			operacion.agregarProfugo(profugo5);						
			operacion.agregarProfugo(profugo6);						
			operacion.agregarProfugo(profugo6);						
		} catch(ProfugoYaExistente zye) {
			zye.getMessage();
		}
		
	}

	@org.junit.Test
	public void agregarZona() throws ZonaYaExistente {
		Zona zona = new Zona("Palermo");
		
		operacion.agregarZona(zona);
	}
	
	@org.junit.Test (expected = ZonaYaExistente.class)
	public void agregarZonaInvalido() throws ZonaYaExistente {
		Zona zona = new Zona("Zona 1");

		operacion.agregarZona(zona);
	}
	
	 @org.junit.Test
	 public void agregarCazador() throws CazadorYaExistente{
		 Cazador cazador = new CazadorUrbano(null, null, 0);
		 
		 operacion.agregarCazador(cazador);
	 }

	 @org.junit.Test (expected = CazadorYaExistente.class)
	 public void agregarCazadorInvalido() throws CazadorYaExistente{
		 operacion.agregarCazador(cazador1);
	 }
	 
	 @org.junit.Test
	 public void agregarProfugo() throws ProfugoYaExistente{
		 Profugo profugo = new Profugo("Menem", null, 0, 0, false);
		 
		 operacion.agregarProfugo(profugo);
	 }

	 @org.junit.Test (expected = ProfugoYaExistente.class)
	 public void agregarProfugoInvalido() throws ProfugoYaExistente{
		 operacion.agregarProfugo(profugo1);
	 }
	 
	 @org.junit.Test
	 public void realizarCapturaPorElCazador1() {
		 assertTrue(operacion.realizarCaptura(cazador1));
		 assertEquals(5, operacion.getProfugosNoCapturados().size());
	 }
	 
	 @org.junit.Test
	 public void realizarCapturaPorElCazador2() {
		 assertFalse(operacion.realizarCaptura(cazador2));
	 }
	 
	 @org.junit.Test
	 public void realizarCapturaPorElCazador3() {
		 assertFalse(operacion.realizarCaptura(cazador3));
	 }
	 
	 @org.junit.Test
	 public void realizarCapturaPorElCazador4() {
		 assertFalse(operacion.realizarCaptura(cazador4));
	 }
	 
	 @org.junit.Test
	 public void realizarCapturaPorElCazador5() {
		 assertFalse(operacion.realizarCaptura(cazador5));
	 }
	 
	 @org.junit.Test
	 public void realizarCapturaPorElCazador6() {
		 assertTrue(operacion.realizarCaptura(cazador6));
	 }

	 @org.junit.Test
	 public void obtenerProfugosCapturadosPorSusCazadores() {
		 Set<Profugo> profugosEsperados = new HashSet<>();
		 
		 assertTrue(operacion.realizarCaptura(cazador1));
		 
		 profugosEsperados.add(profugo1);
		 
		 assertEquals(profugosEsperados, operacion.getProfugosCapturados());
	 }
	 
	 @org.junit.Test
	 public void obtenerAlProfugoMasHabilCapturado() {
		 realizarCapturaPorTodosLosCazadores();
		 System.out.println("Profugo mas habil capturado: ");
		 System.out.println(operacion.getProfugoMasHabilCapturado() + "\n");
	 }

	 
	 @org.junit.Test
	 public void obtenerCazadorConMasCapturasRealizadas() {
		 //realizarCapturaPorTodosLosCazadores();
		 realizarCaptura(cazador1);
		 realizarCaptura(cazador2);
		 realizarCaptura(cazador3);
		 realizarCaptura(cazador4);
		 realizarCaptura(cazador5);
		 realizarCaptura(cazador6);
		 System.out.println("Cazador con mas capturas realizadas: ");
		 System.out.println(operacion.getCazadorConMasCapturasRealizadas() + "\n");
	 }
	 
	 @org.junit.Test
	 public void profugoUnoImplementaEvolucion() throws NivelMaximoDeHabilidadSuperado, InocenciaMinimaAlcanzada {
		 implementarEvolucion(profugo1);
		 
		 assertFalse(operacion.realizarCaptura(cazador1));
	 }
	 
	 @org.junit.Test
	 public void profugoDosImplementaEvolucion() throws NivelMaximoDeHabilidadSuperado, InocenciaMinimaAlcanzada {
		 implementarEvolucion(profugo2);
		 
		 assertTrue(operacion.realizarCaptura(cazador1));
	 }
	 
	 @org.junit.Test
	 public void profugoTresImplementaEvolucion() throws NivelMaximoDeHabilidadSuperado, InocenciaMinimaAlcanzada {
		 implementarEvolucion(profugo3);
		 
		 assertFalse(operacion.realizarCaptura(cazador2));
	 }
	 
	 @org.junit.Test
	 public void profugoCuatroImplementaEvolucion() throws NivelMaximoDeHabilidadSuperado, InocenciaMinimaAlcanzada {
		 implementarEvolucion(profugo4);
		 
		 assertFalse(operacion.realizarCaptura(cazador2));
	 }
	 
	 @org.junit.Test
	 public void profugoCincoImplementaEvolucion() throws NivelMaximoDeHabilidadSuperado, InocenciaMinimaAlcanzada {
		 implementarEvolucion(profugo5);
		 
		 assertFalse(operacion.realizarCaptura(cazador2));
	 }
	 
	 @org.junit.Test
	 public void profugoSeisImplementaEvolucion() throws NivelMaximoDeHabilidadSuperado, InocenciaMinimaAlcanzada {		 
		 implementarEvolucion(profugo6);
		 
		 assertFalse(operacion.realizarCaptura(cazador2));
	 }

	 // <-- Metodos privados -->  
	 
	 private void realizarCapturaPorTodosLosCazadores() {
		 operacion.realizarCaptura(cazador1);
		 operacion.realizarCaptura(cazador2);
		 operacion.realizarCaptura(cazador3);
		 operacion.realizarCaptura(cazador4);
		 operacion.realizarCaptura(cazador5);
		 operacion.realizarCaptura(cazador6);
	 }
	 
	 private void realizarCaptura(Cazador cazador) {
		 operacion.realizarCaptura(cazador);
	 }
	 
	 private void implementarEvolucion(Profugo profugo) throws NivelMaximoDeHabilidadSuperado, InocenciaMinimaAlcanzada {
		 profugo.artesMarcialesAvanzadas();
		 profugo.entrenamientoDeElite();
		 profugo.proteccionLegal();
	 }
}