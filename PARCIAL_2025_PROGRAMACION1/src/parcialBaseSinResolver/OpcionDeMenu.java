package parcialBaseSinResolver;

public abstract class OpcionDeMenu implements Ejecutable, Mostrable {

	private static final String FORMATO_MASCARA = "%s - %s\n";
	private char charSelector;
	private String descripcion;

	public OpcionDeMenu(String descripcion, char charSelector) {
		setDescripcion(descripcion);
		setCharSelector(charSelector);
	}

	public char getCharSelector() {
		return charSelector;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public void mostrar() {
		System.out.printf(FORMATO_MASCARA, charSelector, descripcion);
	}

	private void setCharSelector(char charSelector) {
		this.charSelector = charSelector;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}