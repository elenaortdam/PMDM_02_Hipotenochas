package com.elena.test;

import com.elena.Casilla;
import com.elena.Tablero;
import com.elena.Valores;
import com.elena.nivel.Nivel;
import com.elena.nivel.NivelAvanzado;
import com.elena.nivel.NivelFacil;
import com.elena.nivel.NivelIntermedio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NivelTest {

	private Nivel nivelFacil;
	private Nivel nivelIntermedio;
	private Nivel nivelAvanzado;
	private Tablero tableroTest;

	@BeforeEach
	public void prepareTest() {
		nivelFacil = new NivelFacil();
		nivelIntermedio = new NivelIntermedio();
		nivelAvanzado = new NivelAvanzado();
	}

	private Tablero crearTableroTest(int columnas, int filas) {

		Casilla[][] casillas = new Casilla[filas][columnas];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(false);
			}
		}
		return new Tablero(casillas);
	}

	@Test
	public void hipotenochasNivelFacil() {
		assertEquals(nivelFacil.getHipotenochasOcultas(),
					 Valores.NivelFacil.HIPOTENOCHAS);
	}

	@Test
	public void hipotenochasNivelMedio() {
		assertEquals(nivelIntermedio.getHipotenochasOcultas(),
					 Valores.NivelMedio.HIPOTENOCHAS);
	}

	@Test
	public void hipotenochasNivelAvanzado() {
		assertEquals(nivelAvanzado.getHipotenochasOcultas(),
					 Valores.NivelAvanzado.HIPOTENOCHAS);
	}

	@Test
	public void tableroNivelFacil() {
		Casilla[][] casillas = nivelFacil.crearTablero(nivelFacil.getNombre())
										 .getCasillas();
		Assertions.assertEquals(Valores.NivelFacil.HIPOTENOCHAS,
								getHipotenochasTotales(casillas));
	}

	@Test
	public void tableroNivelMedio() {
		Casilla[][] casillas = nivelIntermedio.crearTablero(nivelIntermedio.getNombre())
											  .getCasillas();
		Assertions.assertEquals(Valores.NivelMedio.HIPOTENOCHAS,
								getHipotenochasTotales(casillas));
	}

	@Test void tableroNivelAvanzado() {
		Casilla[][] casillas = nivelAvanzado.crearTablero(nivelAvanzado.getNombre())
											.getCasillas();
		Assertions.assertEquals(Valores.NivelAvanzado.HIPOTENOCHAS,
								getHipotenochasTotales(casillas));
	}

	@Test
	void deberiaContar3Hipotenochas() {
		Casilla[][] casillas = crearTableroTest(2, 2).getCasillas();
		casillas[0][1].setTieneHipotenocha(true);
		casillas[1][1].setTieneHipotenocha(true);
		casillas[1][0].setTieneHipotenocha(true);
		Nivel.contarHipotenochasAlrededor(casillas, 0, 0);
		Assertions.assertEquals(3, casillas[0][0].getMinasAlrededor());
	}

	@Test
	void contarMinasTablero3x3() {
		Casilla[][] casillas = crearTableroTest(3, 3).getCasillas();
		casillas[0][0].setTieneHipotenocha(true);
		casillas[0][1].setTieneHipotenocha(true);
		casillas[0][2].setTieneHipotenocha(true);
		casillas[1][0].setTieneHipotenocha(true);
		casillas[1][2].setTieneHipotenocha(true);
		casillas[2][0].setTieneHipotenocha(true);
		casillas[2][1].setTieneHipotenocha(true);
		casillas[2][2].setTieneHipotenocha(true);
		Nivel.contarHipotenochasAlrededor(casillas, 1, 1);
		Assertions.assertEquals(8, casillas[1][1].getMinasAlrededor());
	}

	@Test
	void noTieneHipotenochasAlrededor() {
		Casilla[][] casillas = crearTableroTest(2, 2).getCasillas();
		Nivel.contarHipotenochasAlrededor(casillas, 0, 0);
		Assertions.assertEquals(0, casillas[0][0].getMinasAlrededor());
	}

	@Test
	void tiene1HipotenochaAlrededor() {
		Casilla[][] casillas = crearTableroTest(2, 2).getCasillas();
		casillas[0][1].setTieneHipotenocha(true);
		Nivel.contarHipotenochasAlrededor(casillas, 0, 0);
		Assertions.assertEquals(1, casillas[0][0].getMinasAlrededor());
	}

	@Test
	void deberiaLanzarIndexOfBoundsException() {
		Casilla[][] casillas = crearTableroTest(2, 2).getCasillas();
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
								() -> Nivel.contarHipotenochasAlrededor(casillas, 3, 3));
	}

	private int getHipotenochasTotales(Casilla[][] casillas) {
		int counter = 0;
		for (Casilla[] casilla : casillas) {
			for (Casilla value : casilla) {
				if (value.isTieneHipotenocha()) {
					counter++;
				}
			}
		}
		return counter;
	}
}