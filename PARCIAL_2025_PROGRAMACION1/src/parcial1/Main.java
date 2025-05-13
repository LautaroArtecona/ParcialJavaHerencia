package parcial1;

import java.util.Scanner;

import parcial1.clases.Menu;
import parcial1.clases.OpcionAccesoAMenu;
import parcial1.clases.OpcionChequeable;
import parcial1.clases.ToDoList;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Descomentar las siguientes lineas e implementar lo que se ve debajo y pide en el enunciado. 
		ToDoList menuSecundario = new ToDoList("Lista De Tareas", input);
		menuSecundario.registrar(new OpcionChequeable("Escribir Interfaz Chequeable", 'I'));
		menuSecundario.registrar(new OpcionChequeable("Desarrollar Clase OpcionChequeable", 'O'));
		menuSecundario.registrar(new OpcionChequeable("Desarrollar Clase ToDoFooter", 'F'));
		menuSecundario.registrar(new OpcionChequeable("Extender ToDoList desde Menu", 'T'));
		menuSecundario.registrar(new OpcionChequeable("Testear Programa", 'P'));
		menuSecundario.registrar(new OpcionChequeable("Exportar Proyecto", 'R'));
		menuSecundario.registrar(new OpcionChequeable("Entregar Proyecto Exportado y Finalizar el Examen", 'E'));
		Menu menuPrincipal = new Menu("Menu Principal", input);
		menuPrincipal.registrar(new OpcionAccesoAMenu("Listar Tareas", 'L', menuSecundario));
		menuPrincipal.ejecutar();
		System.out.println("Fin del programa");
		input.close();
	}

}
