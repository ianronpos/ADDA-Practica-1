package ejemplos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import utils.Cuadrante; 
import utils.Punto2D;

import java.util.*;

public class Ejemplo1Test {

	private List<Punto2D> puntos; 
	
	
    @Test
    public void testSolucionIterativa() {
        // Test
        Map<Cuadrante, Double> resIterativa = Ejemplo1.solucionIterativa(getPuntos());
        assertEquals(getResult(), resIterativa);
    }
   
    @Test 
    public void testSolucionRecursiva () { 
    	Map<Cuadrante, Double> resRecursiva = Ejemplo1.solucionRecursivaFinal(getPuntos());
    	assertEquals(getResult(), resRecursiva);
    }
    
    private List<Punto2D> getPuntos(){ 
        // Crear lista de puntos en diferentes cuadrantes
        puntos = Arrays.asList(
                new Punto2D(1.0, 1.0),   // Primer cuadrante, X = 1
                new Punto2D(2.0, 3.0),   // Primer cuadrante, X = 2
                new Punto2D(-4.0, 5.0),  // Segundo cuadrante, X = -4
                new Punto2D(-2.0, -3.0), // Tercer cuadrante, X = -2
                new Punto2D(6.0, -1.0),  // Cuarto cuadrante, X = 6
                new Punto2D(4.0, -5.0)   // Cuarto cuadrante, X = 4
        );
        return puntos; 
    }
    
    private Map<Cuadrante, Double> getResult(){ 
    	 Map<Cuadrante, Double> res = Ejemplo1.solucionFuncional(getPuntos());
         return res; 
    }
}
