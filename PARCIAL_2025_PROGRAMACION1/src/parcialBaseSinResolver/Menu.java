package parcialBaseSinResolver;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Ejecutable, Mostrable {
	private ArrayList<OpcionDeMenu> items;
	private OpcionDeSalida salida;
	private String titulo;
	private Scanner input;
	private MenuFooter footer;

	public Menu(String titulo, Scanner input) {
		this(titulo, input, new MenuFooter());
	}
	
	public Menu(String titulo, Scanner input, MenuFooter footer) {
		this.input = input;
		this.footer = footer;
		setTitulo(titulo);
		items = new ArrayList<>();
		salida = new OpcionDeSalida();
	}
	
	protected ArrayList<OpcionDeMenu> getItems() {
		return this.items;
	}

	protected MenuFooter getFooter() {
		return this.footer;
	}

	private OpcionDeMenu buscarOpcion(char caracterIngresado) {
		OpcionDeMenu opcion = null;
		if (caracterIngresado == salida.getCharSelector())
			opcion = salida;
		else {
			int pos = 0;
			while (pos < items.size() && items.get(pos).getCharSelector() != caracterIngresado)
				pos++;
			if (pos < items.size())
				opcion = items.get(pos);
		}
		return opcion;
	}

	@Override
	public void ejecutar() {
		OpcionDeMenu opcion = elegirOpcion();
		while (!opcion.equals(salida)) {
			opcion.ejecutar();
			opcion = elegirOpcion();
		}
	}

	private OpcionDeMenu elegirOpcion() {
		char ch;
		OpcionDeMenu opcion = null;
		do {
			mostrar();
			try {
				ch = input.nextLine().toUpperCase().charAt(0);
				opcion = buscarOpcion(ch);
			} catch (Exception e) {
			}
		} while (opcion == null);
		return opcion;
	}

	public void mostrar() {
		System.out.println("-- " + titulo + " --");
		for (OpcionDeMenu opcion : items) {
			opcion.mostrar();
		}
		salida.mostrar();
		footer.mostrar();
	}

	public void registrar(OpcionDeMenu opcion) {
		if (opcion != null) {
			items.add(opcion);
		}
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
