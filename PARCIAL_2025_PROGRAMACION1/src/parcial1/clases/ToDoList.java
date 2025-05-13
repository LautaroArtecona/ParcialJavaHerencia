package parcial1.clases;

import java.util.Scanner;

public class ToDoList extends Menu {
	
	public ToDoList(String titulo, Scanner input) {
		super(titulo, input, new ToDoFooter());
		((ToDoFooter) this.getFooter()).setMenu(this);
	}
	
	@Override
	public void mostrar() {
		super.mostrar();
	}
	
	public void registrar(OpcionChequeable opcion) {
		super.registrar(opcion);
	}

	public int getCantTareas() {
		return getItems().size();
	}

	public int getCantCumplidas() {
		int value = 0;
		for (OpcionDeMenu opcion : getItems()) {
			if (((OpcionChequeable) opcion).chequeada()) value++;
		}
		return value;
	}

}