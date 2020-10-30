import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class TestCompleto extends TestCase {
	
	
	public static int puntaje = 0;
	public static int MAX_PUNTAJE = 35;
	
	public void test_Llamada_Constructor_OK() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Fecha f1 = new Fecha (2013,1,1,1,1);
			Llamada l1 = new Llamada("1111111111", f1, 80, TipoDeLlamada.ENTRANTE);
			assertEquals("1111111111",l1.getNumero());
			assertEquals(f1,l1.getFecha());
			assertEquals(80,l1.getDuracionEnSegundos());
			assertEquals(TipoDeLlamada.ENTRANTE,l1.getTipoDeLlamada());
			puntaje+=1;
			pass=true;			
		} catch (Exception e) {
			fail();
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	
	
	public void test_Llamada_Constructor_NumeroInvalida() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		String [] numeros = new String []{
				"1",
				"123456789", 
				"12345678912",
				null,
				"          ",
				""};
		Fecha f1 = new Fecha (2013,1,1,1,1);		
		  try {
			for (int i=0;i<6;i++){
				try {
					new Llamada(numeros[i], f1, 80, TipoDeLlamada.ENTRANTE);
					fail("El Constructor acetpo un numero invalido: " + numeros[i]);
				} catch (IllegalArgumentException e) {}	
			}
			
			try {
				new Llamada("1234567890", f1, -1, TipoDeLlamada.ENTRANTE);
				fail("El Constructor acepto una duracion invalida: " + -1);
			} catch (IllegalArgumentException e) {}
			
			try {
				new Llamada("1234567890", null, 1, TipoDeLlamada.ENTRANTE);
				fail("El Constructor acepto una fecha invalida: null");
			} catch (IllegalArgumentException e) {}
			
			try {
				new Llamada("1234567890", f1, 1, null);
				fail("El Constructor acepto un tipo invalido: null");
			} catch (IllegalArgumentException e) {}
			
			puntaje+=3;
			pass=true;			
		} 
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Llamada_toString_saliente() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Fecha f1 = new Fecha (2013,1,1,1,1);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 630, TipoDeLlamada.ENTRANTE);
			System.out.println(l1);
			assertEquals("2013/01/01 01:01, 1234512345, ENTRANTE, 10:30",l1.toString());
			puntaje+=1;
			pass=true;			
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Llamada_toString_entrante() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Fecha f1 = new Fecha (2013,1,1,1,1);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 630, TipoDeLlamada.SALIENTE);
			System.out.println(l1);
			assertEquals("2013/01/01 01:01, 1234512345, SALIENTE, 10:30",l1.toString());
			puntaje+=1;
			pass=true;			
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Llamada_getDuracionLlamadas_mm_ss() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Fecha f1 = new Fecha (2013,1,1,1,1);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 630, TipoDeLlamada.ENTRANTE);
			assertEquals("10:30",l1.getDuracion());
			puntaje+=1;
			pass=true;			
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Llamada_getDuracionLlamadas_m_s() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Fecha f1 = new Fecha (2013,1,1,1,1);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 65, TipoDeLlamada.ENTRANTE);
			assertEquals("01:05",l1.getDuracion());
			puntaje+=1;
			pass=true;			
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	public void test_Llamada_getDuracionLlamadas_mmm_ss() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Fecha f1 = new Fecha (2013,1,1,1,1);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 6035, TipoDeLlamada.ENTRANTE);
			assertEquals("100:35",l1.getDuracion());
			puntaje+=1;
			pass=true;			
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}	
	
	
	public void test_Registro_getDuracionLlamadas() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Registro r = new RegistroDeLlamadas();
			Fecha f1 = new Fecha (2013,1,1,1,1);
			Fecha f2 = new Fecha (2013,1,1,1,2);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 100, TipoDeLlamada.ENTRANTE);
			MiLlamada l2 = new MiLlamada("1234512345", f2, 110, TipoDeLlamada.SALIENTE);
			
			assertEquals (0,r.getDuracionTotalLlamadasDelRegistro());
			r.agregarLlamada(l1);
			assertEquals (100,r.getDuracionTotalLlamadasDelRegistro());
			r.agregarLlamada(l2);
			assertEquals (210,r.getDuracionTotalLlamadasDelRegistro());
			r.limpiarRegistro();
			assertEquals (0,r.getDuracionTotalLlamadasDelRegistro());
			
			puntaje+=1;
			pass=true;			
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	public void test_Registro_getLlamadasEntrantes() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Registro r = new RegistroDeLlamadas();
			Fecha f1 = new Fecha (2013,1,1,1,1);
			Fecha f2 = new Fecha (2013,1,1,1,2);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 100, TipoDeLlamada.ENTRANTE);
			MiLlamada l2 = new MiLlamada("1234512345", f2, 110, TipoDeLlamada.SALIENTE);
			MiLlamada l3 = new MiLlamada("1111111111", f1, 200, TipoDeLlamada.ENTRANTE);
			MiLlamada l4 = new MiLlamada("2222222222", f2, 210, TipoDeLlamada.SALIENTE);
			MiLlamada l5 = new MiLlamada("2222222222", f2, 210, TipoDeLlamada.SALIENTE);
			
			r.agregarLlamada(l1);
			r.agregarLlamada(l2);
			r.agregarLlamada(l3);
			r.agregarLlamada(l4);
			r.agregarLlamada(l5);
			
			List<Llamada> llamadas = r.getLlamadasPorTipo(TipoDeLlamada.ENTRANTE);
			assertEquals(2,llamadas.size());
			assertTrue(llamadas.contains(l1));
			assertFalse(llamadas.contains(l2));
			assertTrue(llamadas.contains(l3));
			assertFalse(llamadas.contains(l4));
			assertFalse(llamadas.contains(l5));
			
			llamadas = r.getLlamadasPorTipo(TipoDeLlamada.SALIENTE);
			
			assertEquals(3,llamadas.size());
			assertFalse(llamadas.contains(l1));
			assertTrue(llamadas.contains(l2));
			assertFalse(llamadas.contains(l3));
			assertTrue(llamadas.contains(l4));
			assertTrue(llamadas.contains(l5));
			
			puntaje+=2;
			pass=true;			
		} catch (Exception e) {
			fail();
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Registro_getLlamadasPorDuracion() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Registro r = new RegistroDeLlamadas();
			Fecha f1 = new Fecha (2013,1,1,1,1);
			Fecha f2 = new Fecha (2013,1,1,1,2);
			MiLlamada l1 = new MiLlamada("1234512345", f1, 100, TipoDeLlamada.ENTRANTE);
			MiLlamada l2 = new MiLlamada("1234512345", f2, 110, TipoDeLlamada.SALIENTE);
			MiLlamada l3 = new MiLlamada("1111111111", f1, 200, TipoDeLlamada.ENTRANTE);
			MiLlamada l4 = new MiLlamada("2222222222", f2, 210, TipoDeLlamada.SALIENTE);
			
			r.agregarLlamada(l1);
			r.agregarLlamada(l2);
			r.agregarLlamada(l3);
			r.agregarLlamada(l4);
			
			List<Llamada> llamadas = r.getLlamadasPorDuracion(1, 40, 1, 50);
			assertEquals(2,llamadas.size());
			assertTrue(llamadas.contains(l1));
			assertTrue(llamadas.contains(l2));
			assertFalse(llamadas.contains(l3));
			assertFalse(llamadas.contains(l4));
			
			llamadas = r.getLlamadasPorDuracion(3,0,3,20);
			assertEquals(1,llamadas.size());
			assertFalse(llamadas.contains(l1));
			assertFalse(llamadas.contains(l2));
			assertTrue(llamadas.contains(l3));
			assertFalse(llamadas.contains(l4));
			
			llamadas = r.getLlamadasPorDuracion(3,30,99,0);
			assertEquals(1,llamadas.size());
			assertFalse(llamadas.contains(l1));
			assertFalse(llamadas.contains(l2));
			assertFalse(llamadas.contains(l3));
			assertTrue(llamadas.contains(l4));
			
			llamadas = r.getLlamadasPorDuracion(0,0,1,0);
			assertEquals(0,llamadas.size());
			
			puntaje+=2;
			pass=true;			
		} catch (Exception e) {
			fail();
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	
	
	
	public void test_Registro_getLlamadasPorDuracion_Invalido2() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Registro r = new RegistroDeLlamadas();
			r.getLlamadasPorDuracion(1,0,0,30);
			fail();			
		} catch (Exception e) {
			puntaje+=1;
			pass=true;
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Registro_getLlamadasPorDuracion_Invalido3() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		Registro r = new RegistroDeLlamadas();
		try {
			r.getLlamadasPorDuracion(1,60,2,30);
			pass=false;			
		} catch (Exception e) {
			pass=true;
		}
		
		try {
			r.getLlamadasPorDuracion(1,30,2,60);
			pass=false;			
		} catch (Exception e) {
			pass=pass && true;
		}
		
		try {
			r.getLlamadasPorDuracion(-1,30,2,30);
			pass=false;			
		} catch (Exception e) {
			pass=pass && true;
		}
		
		try {
			r.getLlamadasPorDuracion(1,-30,2,30);
			pass=false;			
		} catch (Exception e) {
			pass=pass && true;
		}
		
		try {
			r.getLlamadasPorDuracion(1,30,-2,30);
			pass=false;			
		} catch (Exception e) {
			pass=pass && true;
		}
		
		try {
			r.getLlamadasPorDuracion(1,30,2,-30);
			pass=false;			
		} catch (Exception e) {
			pass=pass && true;
		}
		
		System.out.println (pass?"PASSED":"FAILED");
		if (!pass)
			fail();
		
		puntaje+=2;
		
	}
	
	
	public void test_Fecha_Constructor_OK() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Fecha f1 = new Fecha (2013,10,11,21,1);
			
			assertEquals(2013,f1.getAnio());
			assertEquals(10,f1.getMes());
			assertEquals(11,f1.getDia());
			assertEquals(21,f1.getHora());
			assertEquals(1,f1.getMinuto());
			
			f1 = new Fecha (2013,10,11,0,1);
			f1 = new Fecha (2013,10,11,1,0);
			
			puntaje+=1;
			pass=true;			
		} catch (Exception e) {
			fail();
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	
	
	public void test_Fecha_Constructor_FechaInvalida() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		int [][] fechas = new int [][] {{2012,10,11,21,1},
				{2013,0,11,21,1}, 
				{2013,13,11,21,1},
				{2013,1,0,21,1},
				{2013,1,32,21,1},
				{2013,2,29,21,1},
				{2013,4,31,21,1},
				{2013,6,31,21,1},
				{2013,9,31,21,1},
				{2013,11,31,21,1},
				{2013,11,30,24,1},				
				{2013,11,30,22,60}};
		  try {
			for (int i=0;i<13;i++){
				try {
					new Fecha (fechas[i][0],fechas[i][1],fechas[i][2],fechas[i][3],fechas[i][4]);
					fail();
				} catch (Exception e) {}	
			}
			puntaje+=3;
			pass=true;			
		} 
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	
	public void test_Visor_convertirLista() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			List<Llamada> l = initLlamadas();
			Formateable f = new Visor();
			String s1 = f.convertirListaComoString(l);
			
			String s[] = s1.split("\n");
			assertEquals(5,s.length);
			assertEquals(l.get(0).toString(), s[0]);
			assertEquals(l.get(1).toString(), s[1]);
			assertEquals(l.get(2).toString(), s[2]);
			assertEquals(l.get(3).toString(), s[3]);
			assertEquals(l.get(4).toString(), s[4]);
			
			puntaje+=2;
			pass=true;			
		} catch (Exception e) {
			fail();
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Visor_convertirListaAmigable() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			List<Llamada> l = initLlamadas();
			Formateable f = new Visor();
			String s1 = f.convertirListaComoStringAmigable(l, initContactos());
			
			System.out.println (s1);
			
			String s[] = s1.split("\n");
			assertEquals(5,s.length);
			
			assertEquals("2013/01/01 01:01, 1234512345, ENTRANTE, 01:20", s[0]);
			assertEquals("2013/01/01 01:02, 1234512345, SALIENTE, 01:50", s[1]);
			assertEquals("2013/01/01 01:01, Juan Perez, ENTRANTE, 03:20", s[2]);
			assertEquals("2013/01/01 01:02, Julieta Alvarez, SALIENTE, 04:10", s[3]);
			assertEquals("2013/01/01 01:02, Julieta Alvarez, ENTRANTE, 00:10", s[4]);
			
			puntaje+=3;
			pass=true;			
		} catch (Exception e) {
			fail();
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	
	
	
	
	public void test_Visor_Estadisticas() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			List<Llamada> l = initLlamadas();
			Formateable f = new Visor();
			Map <String, EstadisticasNumero> m = new HashMap <String,EstadisticasNumero>();
			m.put("123", new EstadisticasNumero());
			m.put("1234", new EstadisticasNumero());
			String s = f.convertirMapaEstadisticaComoString(m);
			String s1[] = s.split("\n");
			assertEquals (s1.length,2);
			
			
			puntaje+=1;
			pass=true;			
		} catch (Exception e) {
			fail();
		}
		finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Registro_getMapaEstadistica() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Registro r = new MiRegistroDeLlamadas();
			r.getRegistroCompleto().clear();
			r.getRegistroCompleto().addAll(initLlamadas2());
					
			Map<String,EstadisticasNumero> map = r.getMapaDeEstadisticasDelRegistroCompleto();
			assertEquals(map.size(),2);
			EstadisticasNumero e = map.get("1111111111");
			assertEquals(e.getEntrantes(),2);
			assertEquals(e.getSalientes(),3);
			assertEquals(e.getDuracionEntrantes(),280);
			assertEquals(e.getDuracionSalientes(),390);
			
			e = map.get("2222222222");
			assertEquals(e.getEntrantes(),1);
			assertEquals(e.getSalientes(),0);
			assertEquals(e.getDuracionEntrantes(),10);
			assertEquals(e.getDuracionSalientes(),0);
			
			r.getRegistroCompleto().clear();
			map = r.getMapaDeEstadisticasDelRegistroCompleto();
			assertEquals(map.size(),0);
			
			
			
			puntaje+=5;
			pass=true;		
		} catch (Exception e){
			fail();
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Registro_getEstadisticaPorNumero() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Registro r = new RegistroDeLlamadas();
			EstadisticasNumero e = r.getEstadisticasPorNumero(initLlamadas2(),"1111111111");
			assertEquals(e.getEntrantes(),2);
			assertEquals(e.getSalientes(),3);
			assertEquals(e.getDuracionEntrantes(),280);
			assertEquals(e.getDuracionSalientes(),390);
			
			e = r.getEstadisticasPorNumero(initLlamadas2(),"2222222222");
			assertEquals(e.getEntrantes(),1);
			assertEquals(e.getSalientes(),0);
			assertEquals(e.getDuracionEntrantes(),10);
			assertEquals(e.getDuracionSalientes(),0);
			
			e = r.getEstadisticasPorNumero(initLlamadas2(),"3333333333");
			assertEquals(e.getEntrantes(),0);
			assertEquals(e.getSalientes(),0);
			assertEquals(e.getDuracionEntrantes(),00);
			assertEquals(e.getDuracionSalientes(),0);

			e = r.getEstadisticasPorNumero(new ArrayList<Llamada> (),"11111111111");
			assertEquals(e.getEntrantes(),0);
			assertEquals(e.getSalientes(),0);
			assertEquals(e.getDuracionEntrantes(),00);
			assertEquals(e.getDuracionSalientes(),0);
			
			puntaje+=2;
			pass=true;		
		} catch (Exception e){
			fail();
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void test_Registro_getEstadisticaPorNumero_Invalido() {
		System.out.print ("Running "+this.getName()+"...");
		boolean pass=false;
		try {
			Registro r = new RegistroDeLlamadas();
			EstadisticasNumero e = r.getEstadisticasPorNumero(new ArrayList<Llamada> (),null);
			fail();		
		} catch (Exception e){
			puntaje+=1;
			pass=true;
		} finally { 
			System.out.println (pass?"PASSED":"FAILED");
		}
	}
	
	public void testFINAL(){
		System.out.println("Nota: ("+puntaje+"/"+MAX_PUNTAJE+") " + 100.0 * (puntaje) / MAX_PUNTAJE );
	}
	
	private List<Llamada> initLlamadas(){
		List<Llamada> l = new ArrayList<Llamada> ();
		Fecha f1 = new Fecha (2013,1,1,1,1);
		Fecha f2 = new Fecha (2013,1,1,1,2);
		MiLlamada l1 = new MiLlamada("1234512345", f1, 80, TipoDeLlamada.ENTRANTE);
		MiLlamada l2 = new MiLlamada("1234512345", f2, 110, TipoDeLlamada.SALIENTE);
		MiLlamada l3 = new MiLlamada("1111111111", f1, 200, TipoDeLlamada.ENTRANTE);
		MiLlamada l4 = new MiLlamada("2222222222", f2, 250, TipoDeLlamada.SALIENTE);
		MiLlamada l5 = new MiLlamada("2222222222", f2, 10, TipoDeLlamada.ENTRANTE);
		l.add(l1);
		l.add(l2);
		l.add(l3);
		l.add(l4);
		l.add(l5);
		return l;
		
	}
	private List<Llamada> initLlamadas2(){
		List<Llamada> l = new ArrayList<Llamada> ();
		Fecha f1 = new Fecha (2013,1,1,1,1);
		MiLlamada l1 = new MiLlamada("1111111111", f1, 80, TipoDeLlamada.ENTRANTE);
		MiLlamada l2 = new MiLlamada("1111111111", f1, 110, TipoDeLlamada.SALIENTE);
		MiLlamada l3 = new MiLlamada("1111111111", f1, 200, TipoDeLlamada.ENTRANTE);
		MiLlamada l4 = new MiLlamada("1111111111", f1, 250, TipoDeLlamada.SALIENTE);
		MiLlamada l5 = new MiLlamada("1111111111", f1, 30, TipoDeLlamada.SALIENTE);
		MiLlamada l6 = new MiLlamada("2222222222", f1, 10, TipoDeLlamada.ENTRANTE);
		l.add(l1);
		l.add(l2);
		l.add(l3);
		l.add(l4);
		l.add(l5);
		l.add(l6);
		return l;
		
	}
	private LibretaDeContactos initContactos(){
		LibretaDeContactos lc = new LibretaDeContactos();
		Contacto c1 = new Contacto ("Juan", "Perez",      "1111111111");
		Contacto c2 = new Contacto ("Julieta", "Alvarez", "2222222222");
		lc.agregarContacto(c1);
		lc.agregarContacto(c2);
		return lc;
		
	}
	
	class MiLlamada extends Llamada {
		 public MiLlamada (String numero, Fecha fecha, int duracion, TipoDeLlamada tipo){
			 if (numero == null ||  numero.trim().length() != 10)
					throw new IllegalArgumentException();
				
				if (duracion < 0)
					throw new IllegalArgumentException();
					
				this.numero = numero.trim();
				this.fecha = fecha;
				this.duracionEnSegundos = duracion;
				this.saliente = tipo;
		 }
		 
			
	}
	
	class MiRegistroDeLlamadas extends RegistroDeLlamadas {
	
		public EstadisticasNumero getEstadisticasPorNumero (List<Llamada> llamadas, String numero) throws ParametrosInconsistentesException{
			if (llamadas == null || numero == null)
				throw new ParametrosInconsistentesException();
			EstadisticasNumero e = new EstadisticasNumero();
			for (Llamada l : llamadas){
				 if (l.getNumero().equals(numero)){
					 if (TipoDeLlamada.SALIENTE.equals(l.getTipoDeLlamada())) {
						 e.incrementarSalientes();
						 e.incremetarDuracionSalientes(l.getDuracionEnSegundos());
					 } else {
						 e.incrementarEntrantes();
						 e.incrementarDuracionEntrantes(l.getDuracionEnSegundos());
					 }
				 }
			}
			return e;
		}	
	}
}


