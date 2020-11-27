package com.elena;

public class Tablero {

	private final Casilla[][] casillas;

	public Tablero(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	@Override public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Casilla[] casilla : casillas) {
			for (Casilla value : casilla) {
				stringBuilder.append(value).append(" ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
