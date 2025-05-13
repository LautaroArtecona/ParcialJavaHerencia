package parcial1.clases;

public class ToDoFooter extends MenuFooter {
	
	ToDoList menu;
	
	public ToDoFooter() {
		this.menu = null;
	}
	
	public void setMenu(ToDoList menu) {
		this.menu = menu;
	}
	
	@Override
	public void mostrar() {
		if (this.menu != null)
			System.out.printf("Cumplidas %d tareas de %d\n", this.menu.getCantCumplidas(), this.menu.getCantTareas());
		super.mostrar();
	}

}
