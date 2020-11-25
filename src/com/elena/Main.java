package com.elena;

import com.elena.nivel.Nivel;
import com.elena.nivel.NivelFacil;

public class Main {

	public static void main(String[] args) {
		Nivel nivel = new NivelFacil();
		Tablero tablero = nivel.crearTablero("Facil");
		nivel.contarHipotenochasAlrededor(tablero, 0, 0);
		System.out.println(tablero.toString());
		System.out.println(nivel.test(tablero.getCasillas()));
	}
}
