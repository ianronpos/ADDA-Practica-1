package ejemplos;

import java.util.stream.Stream;

import utils.Tupla;

public class Ejemplo2 {
	public static String iterativa(Integer a, Integer b) { 
		String res = ""; 
		while(!(a < 5 || b < 5)) { 
			res += String.valueOf(a+b); 
			a = a/2; 
			b = b-2; 
		}
		res += String.format("(%d)", a*b);
		
		return res; 
	}

	public static String recursivaNoFinal(Integer a, Integer b) { 
		String res = ""; 
		if(a < 5 || b < 5) { 
			res += String.format("(%d)", a*b); 
			return res; 
		} else { 
			res += String.valueOf(a+b); 
			return res + recursivaNoFinal(a/2, b-2); 
		}
	}
	
	public static String recursivaFinal(Integer a, Integer b) { 
		String res = ""; 
		return recursivaFinalAux(a, b, res); 
	}
	
	private static String recursivaFinalAux(Integer a, Integer b, String res) { 
		if(a < 5 || b < 5) { 
			return res.concat(String.format("(%d)", a*b));
		} else { 
			res += String.valueOf(a+b); 
			return recursivaFinalAux(a/2, b-2, res); 
		}
	}
	
	public static String funcional(Integer a, Integer b) {
		Tupla t = Stream.iterate(Tupla.first(a, b), i -> i.next())
				.filter(i -> i.a()<5 || i.b() < 5)
				.findFirst()
				.get(); 
		return t.ac() + String.format("(%d)", t.a() * t.b()); 
	}
}
