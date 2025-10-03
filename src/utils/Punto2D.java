package utils;

import utils.Cuadrante;

public class Punto2D {
	private Double x; 
	private Double y;
	
	public Punto2D(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Cuadrante cuadrante() { 
		Cuadrante c; 
		if(this.x >= 0 && this.y >= 0) c = Cuadrante.PRIMER_CUADRANTE; 
		else if(this.x >= 0  && this.y <= 0) c = Cuadrante.CUARTO_CUADRANTE;
		else if(this.x <= 0 && this.y >= 0) c = Cuadrante.SEGUNDO_CUADRANTE;
		else c = Cuadrante.TERCER_CUADRANTE;
		return c; 
	}
	

	public Double getX() {
		return x;
	}


	public void setX(Double x) {
		this.x = x;
	}


	public Double getY() {
		return y;
	}


	public void setY(Double y) {
		this.y = y;
	} 
	
	
}
