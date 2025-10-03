package utils;

public record Tupla(String ac, Integer a, Integer b) {
	public static Tupla of(String s, Integer a, Integer b) { 
		return new Tupla(s, a, b); 
	} 	
	
	public static Tupla first(Integer a, Integer b) { 
		return of("", a, b); 
	}
	
	public Tupla next() { 
		return of(ac + String.valueOf(a+b), a/2, b -2); 
	}
}
