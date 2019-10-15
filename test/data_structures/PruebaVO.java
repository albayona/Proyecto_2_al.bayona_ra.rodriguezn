package data_structures;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class PruebaVO implements Comparable<PruebaVO>{
	
	//--------------------------------------------------------
	//Atributos
	//--------------------------------------------------------
	
	private String estacionInicio;
	
	private String estacionFinal;
	
	private int duracion;
	
	//--------------------------------------------------------
	//Constructores
	//--------------------------------------------------------
	
	public PruebaVO(String estacionInicio, String estacionFinal, int duracion) {
		this.estacionInicio =  estacionInicio;
		this.estacionFinal =  estacionFinal;
		this.duracion = duracion;
	}

	public PruebaVO() {
		//Constructor vacio
		estacionInicio = null;
		estacionFinal = null;
		duracion = 0;
	}

	
	@Override
	public int compareTo(PruebaVO param) {
		int comp = this.compareByInitial(param);
		if(comp == 0) {
			comp = this.compareByFinal(param);
			if(comp == 0) {
				comp = this.compareByDuration(param);
			}
		}
		return comp;
	}
	
	
	//Auxiliar
	
	private int compareByInitial(PruebaVO param) {
		int comparacion = estacionInicio.compareToIgnoreCase(param.getEstacionInicio());
		return (comparacion > 0) ? 1 : (comparacion < 0) ? -1 : 0;  
	}
	
	private int compareByFinal(PruebaVO param) {
		int comparacion = estacionFinal.compareToIgnoreCase(param.getEstacionFinal());
		return (comparacion > 0) ? 1 : (comparacion < 0) ? -1 : 0;  
	}

	private int compareByDuration(PruebaVO param) {
		int comparacion = duracion - param.getDuracion();
		return (comparacion > 0) ? 1 : (comparacion < 0) ? -1 : 0;  
	}
	
	
	
	//--------------------------------------------------------
	//Getters & Setters
	//--------------------------------------------------------
	public String getEstacionInicio() {
		return estacionInicio;
	}

	public void setEstacionInicio(String estacionInicio) {
		this.estacionInicio = estacionInicio;
	}

	public String getEstacionFinal() {
		return estacionFinal;
	}

	public void setEstacionFinal(String estacionFinal) {
		this.estacionFinal = estacionFinal;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	

}
