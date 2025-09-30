package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ejercicio1 {

	// Del enunciado:
	public static Map<Integer,List<String>> solucionFuncional(Integer varA, String varB, Integer varC, String varD, Integer varE) {
		UnaryOperator<EnteroCadena> nx = elem -> {
			return EnteroCadena.of(elem.a()+2,
				elem.a()%3==0?
					elem.s()+elem.a().toString():
					elem.s().substring(elem.a()%elem.s().length()));
		};					
		return Stream.iterate(EnteroCadena.of(varA,varB), elem -> elem.a() < varC, nx)
					.map(elem -> elem.s() + varD)
					.filter(nom -> nom.length() < varE)
					.collect(Collectors.groupingBy(String::length));
	}
	
	public static Map<Integer, List<String>> solucionIterativa(Integer varA, String varB, Integer varC, String varD,
			Integer varE) {
		// Creamos el mapa y el primer elemento 0
		Map<Integer, List<String>> res = new HashMap<Integer, List<String>>();
		EnteroCadena elem = EnteroCadena.of(varA, varB);

		while (elem.a < varC) {
			String c = elem.s() + varD; //Guardamos el String
			if (c.length() < varE) { //Comprobamos condicion
				res.putIfAbsent(c.length(), new ArrayList<String>()); //Si no existe la clave, la creamos con una lista vacia
				res.get(c.length()).add(c); //Añadimos el valor 
			}
			elem = EnteroCadena.of(elem.a() + 2, //Como se modifica la secuencia
					elem.a() % 3 == 0 ? elem.s() + elem.a().toString()
					: elem.s().substring(elem.a() % elem.s().length()));
		}
		return res;
	}
	
	public static Map<Integer,List<String>> solucionRecursivaFinal(Integer varA, String varB, Integer varC, String varD, Integer varE) {
		Map<Integer, List<String>> res = new HashMap<Integer, List<String>>(); 
		EnteroCadena elem = EnteroCadena.of(varA, varB); 
		return solucionRecursivaFinalAux(varC, varD, varE, res, elem); //Llamada recursiva al metodo auxiliar
	}
	
	private static Map<Integer, List<String>> solucionRecursivaFinalAux(Integer varC, String varD, Integer varE, 
		Map<Integer, List<String>> res, EnteroCadena elem){ 
		if(elem.a() >= varC) { //caso base 
			return res; 
		} else { 
			String c = elem.s() + varD;
			res.putIfAbsent(c.length(), new ArrayList<String>()); //Si no existe la clave, la creamos con una lista vacia
			res.get(c.length()).add(c); //Añadimos el valor 
			
			elem = EnteroCadena.of(elem.a() + 2, //Como se modifica la secuencia
					elem.a() % 3 == 0 ? elem.s() + elem.a().toString()
					: elem.s().substring(elem.a() % elem.s().length()));
			return solucionRecursivaFinalAux(varC, varD, varE, res, elem);
		}
	}
	
	public record EnteroCadena(Integer a, String s) {

		public static EnteroCadena of(Integer i, String o) {
			return new EnteroCadena(i, o); 
		}		
	}

}
