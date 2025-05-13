package parcial1.clases;

import parcial1.interfaces.Chequeable;

public class OpcionChequeable extends OpcionDeMenu implements Chequeable {
	
	private static final String FORMATO_IMPRESION = "[%s] ";
	private static final char DESCHEQUEADA = ' ';
	private static final char CHEQUEADA = '*';
	private char estadoActual;

	public OpcionChequeable(String descripcion, char charSelector) {
		this(descripcion, charSelector, false);
	}

	public OpcionChequeable(String descripcion, char charSelector, boolean arrancaChequeada) {
		super(descripcion, charSelector);
		if (arrancaChequeada)
			estadoActual = CHEQUEADA;
		else
			estadoActual = DESCHEQUEADA;
	}

	@Override
	public void mostrar() {
		System.out.printf(FORMATO_IMPRESION, estadoActual);
		super.mostrar();
	}

	@Override
	public void ejecutar() {
		if (chequeada()) {
			deschequear();
		} else {
			chequear();
		}
	}

	@Override
	public void chequear() {
		estadoActual = '*';
	}

	@Override
	public void deschequear() {
		estadoActual = DESCHEQUEADA;
	}

	@Override
	public boolean chequeada() {
		return estadoActual == CHEQUEADA;
	}

}
