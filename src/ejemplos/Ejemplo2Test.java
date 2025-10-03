package ejemplos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Ejemplo2Test {

	private final static Integer a = 40; 
	private final static Integer b = 15; 
	private final static String resultado = "55332114(14)"; 

	@Test 
	public void testIterativa() { 
		assertEquals(Ejemplo2.iterativa(a, b), resultado);
	}
	
	@Test
	public void testRecursivaNoFinal() { 
		assertEquals(Ejemplo2.recursivaNoFinal(a, b), resultado);
	}
	
	@Test 
	public void testRecursivaFinal() { 
		assertEquals(Ejemplo2.recursivaFinal(a, b), resultado);
	}
	
	@Test 
	public void testFuncional() { 
		assertEquals(Ejemplo2.funcional(a, b), resultado);
	}
	
	//TODO: SUBIR GITHUB
}
