package com.elena.nivel;

public class NivelFacil extends Nivel{
	@Override public String getNombre() {
		return "Facil";
	}

	@Override public int getFilas() {
		return 8;
	}

	@Override public int getColumnas() {
		return 8;
	}

	@Override public int getHipotenochasOcultas() {
		return 10;
	}


}
