package view;

public class MVCView
{
	/**
	 * Metodo constructor
	 */
	public MVCView()
	{

	}

	public void printMenu()
	{
		System.out.println("1. Cargar los datos.");
		System.out.println("A1. Requerimiento 1 de la parte A");
		System.out.println("A2. Requerimiento 2 de la parte A");
		System.out.println("A3. Requerimiento 3 de la parte A");
		System.out.println("B1. Requerimiento 1 de la parte B");
		System.out.println("B2. Requerimiento 2 de la parte B");
		System.out.println("B3. Requerimiento 3 de la parte B");
		System.out.println("C1. Requerimiento 1 de la parte C");
		System.out.println("C2. Requerimiento 2 de la parte C");
		System.out.println("C3. Requerimiento 3 de la parte C");
		System.out.println("C4. Requerimiento 4 de la parte C");

	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}

}
