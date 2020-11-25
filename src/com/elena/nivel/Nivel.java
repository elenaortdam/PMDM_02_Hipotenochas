package com.elena.nivel;

import com.elena.Casilla;
import com.elena.Tablero;

import java.util.Random;

public abstract class Nivel {

	private String nombre;
	private int filas;
	private int columnas;
	private int hipotenochasOcultas;

	abstract public String getNombre();

	abstract public int getFilas();

	abstract public int getColumnas();

	abstract public int getHipotenochasOcultas();

	//TODO: elena hacer el resto de niveles
	//todo: elena ¿quitar el asignar las hipotenochas al principio?
	public Tablero crearTablero(String nombreNivel) {
		Nivel nivel = crearNivel(nombreNivel);
		Casilla[][] casillas = new Casilla[nivel.getColumnas()][nivel.getFilas()];
		int hipotenochasTotales = 0;
		for (int i = 0; i < nivel.getColumnas(); i++) {
			int maxHipotenochasFila = nivel.getHipotenochasOcultas() / nivel.getFilas();
			int hipotenochasCreadas = 0;
			int numeroRandom = getRandomNumber(0, nivel.getColumnas() - 1);
			for (int j = 0; j < nivel.getFilas(); j++) {
				casillas[i][j] = new Casilla(false);
				if (hipotenochasTotales < nivel.getHipotenochasOcultas()
						&& hipotenochasCreadas < maxHipotenochasFila
						&& j == numeroRandom) {
					casillas[i][j] = new Casilla(true);
					hipotenochasTotales++;
					hipotenochasCreadas++;
				} else {
					casillas[i][j] = new Casilla(false);
				}


			}
		}
		Tablero tablero = new Tablero(casillas);

		while (hipotenochasTotales < nivel.getHipotenochasOcultas()) {
			asignarHipotenochas(tablero, getRandomNumber(0, nivel.getFilas() - 1),
								getRandomNumber(0, nivel.getColumnas() - 1));
			hipotenochasTotales++;
		}

		return tablero;
	}

	//todo: elena ver como se escoge del menu si devuelve un int o el valor
	private Nivel crearNivel(String nombreNivel) {
		Nivel nivel = null;

		switch (nombreNivel) {
			case "Facil":
				nivel = new NivelFacil();
				break;
			case "Intermedio":
				//todo: elena: hacer nivel intermedio
				break;
			case "Avanzado":
				//todo: elena: hacer nivel avanzado
				break;
			default:
				nivel = new NivelFacil();
		}
		if (nivel == null) {
			throw new IllegalArgumentException("Ha ocurrido un error al detectar el nivel");
		}

		return nivel;
	}

	public void contarHipotenochasAlrededor(Tablero tablero, int celdaX, int celdaY) {
		int totalHipotenochas = 0;
		for (int i = celdaX - 1; i <= celdaX + 1; i++) {
			for (int j = celdaY - 1; j <= celdaY + 1; j++) {
				try {
					if (tablero.getCasillas()[i][j].isTieneHipotenocha()) {
						totalHipotenochas++;
					}
				} catch (ArrayIndexOutOfBoundsException ignored) {
				}

			}
		}
		tablero.getCasillas()[celdaX][celdaY].setHipotenochasAlrededor(totalHipotenochas);
	}

	//TODO: elena
	private void descubrirMinas() {

	}

	public int test(Casilla[][] casillas) {
		int counter = 0;
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j].isTieneHipotenocha()) {
					counter++;
				}
			}
		}
		return counter;
	}

	private void asignarHipotenochas(Tablero tablero, int i, int j) {
		if (!tablero.getCasillas()[i][j].isTieneHipotenocha()) {
			tablero.getCasillas()[i][j].setTieneHipotenocha(true);
		} else {
			try {
				asignarHipotenochas(tablero, i, j + 1);
			} catch (ArrayIndexOutOfBoundsException ignored) {
				asignarHipotenochas(tablero, i, 0);
			}
		}
	}

	private int getRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}
}
