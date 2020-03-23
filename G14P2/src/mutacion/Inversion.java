package mutacion;

import java.util.ArrayList;
import java.util.Random;

import cromosoma.Cromosoma;

public class Inversion {

	int probMut;
	int tamPoblacion;
	Cromosoma[] poblacion;
	
	public Inversion (double probMut, int tamPoblacion, Cromosoma[] poblacion) {
		this.probMut = (int)(this.probMut*100);
		this.tamPoblacion = tamPoblacion;
		this.poblacion = poblacion;
	}
	
	
	public void mutar() {
		
		for (int i = 0; i < this.tamPoblacion; ++i) {
			invertir(this.poblacion[i].getFenotipo());
		}
		
	}
	
	private void invertir(ArrayList<Integer> c) {
		Random rn = new Random();
		int pos = rn.nextInt(this.tamPoblacion-this.probMut);
		int tamSeg = (this.tamPoblacion*this.probMut)/100;
		ArrayList<Integer> aux = new ArrayList();
		
		for(int i = pos; i < pos+tamSeg; ++i) {
			aux.set(i-pos, c.get(pos));
		}
		int cont = 0;
		for(int j = pos+tamSeg; j > pos; --j) {
			c.set(j, aux.get(cont));
			cont++;
		}
	}
	
	
}
