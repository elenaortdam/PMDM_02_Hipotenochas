package com.elena;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Tablero {

	private Casilla[][]casillas;
	private List<Casilla> casillasL;

	public Tablero(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	@Override public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i< casillas.length;i++){
			for(int j= 0; j<casillas[i].length; j++){
				stringBuilder.append(casillas[i][j]).append(" ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
