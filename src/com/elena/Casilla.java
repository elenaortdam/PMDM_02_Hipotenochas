package com.elena;

public class Casilla {

	private boolean tieneHipotenocha;
	private int minasAlrededor;

	public Casilla( boolean tieneHipotenocha) {
		this.tieneHipotenocha = tieneHipotenocha;
	}

	public boolean isTieneHipotenocha() {
		return tieneHipotenocha;
	}

	public void setTieneHipotenocha(boolean tieneHipotenocha) {
		this.tieneHipotenocha = tieneHipotenocha;
	}

	public int getMinasAlrededor() {
		return minasAlrededor;
	}

	public void setHipotenochasAlrededor(int minasAlrededor) {
		this.minasAlrededor = minasAlrededor;
	}

	@Override public String toString() {
		int mina = 0;
		if(isTieneHipotenocha()){
			mina = 1;
		}
		return mina == 0 ? "[ ]": "[" + mina + "]";
	}
}
