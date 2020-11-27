package com.elena;

public final class Valores {
	private Valores() {
	}

	public static final class NivelFacil {
		public static final String NOMBRE = "FACIL";
		public static final int HIPOTENOCHAS = 10;
		public static final int COLUMNAS = 8;
		public static final int FILAS = COLUMNAS;
	}

	public static final class NivelMedio {
		public static final String NOMBRE = "INTERMEDIO";
		public static final int HIPOTENOCHAS = 30;
		public static final int COLUMNAS = 12;
		public static final int FILAS = COLUMNAS;
	}

	public static final class NivelAvanzado {
		public static final String NOMBRE = "AVANZADO";
		public static final int HIPOTENOCHAS = 60;
		public static final int COLUMNAS = 16;
		public static final int FILAS = COLUMNAS;
	}
}
