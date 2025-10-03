package ejemplos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Cuadrante;
import utils.Punto2D;

public class Ejemplo1 {
	
	public static Map<Cuadrante, Double> solucionFuncional(List<Punto2D> ls){
		return ls.stream().collect(Collectors.groupingBy(
					Punto2D::cuadrante, 
					Collectors.reducing(0., p -> p.getX(), (a, b) -> a + b)));
	}
	
	public static Map<Cuadrante, Double> solucionIterativa(List<Punto2D> ls){ 
		Map<Cuadrante, Double> res = new HashMap<Cuadrante, Double>(); 
		
		for(Punto2D p: ls) { //Recoriendo los puntos
			res.putIfAbsent(p.cuadrante(), 0.); //Si no esta el cuadrante se añade
			res.put(p.cuadrante(), res.get(p.cuadrante()) + p.getX()); //Sumamos las cordenadas X de los puntos de ese cuadrante
		}
		return res; 
	}
	
	public static Map<Cuadrante, Double> solucionRecursivaFinal(List<Punto2D> ls){ 
		Map<Cuadrante, Double> res = new HashMap<Cuadrante, Double>();
		return solucionRecursivaFinalAux(res, ls, 0); 
	}
	
	private static Map<Cuadrante, Double> solucionRecursivaFinalAux(Map<Cuadrante, Double> res, List<Punto2D> ls, Integer i){
		try {
			Punto2D p = ls.get(i); 
			res.putIfAbsent(p.cuadrante(), 0.); 
			res.put(p.cuadrante(), res.get(p.cuadrante()) + p.getX()); 
			i += 1; 
			return solucionRecursivaFinalAux(res, ls, i);  
		} catch (Exception e) {
			return res; 
		}
	}
}
