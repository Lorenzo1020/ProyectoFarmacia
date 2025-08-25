package Main;

import java.util.Scanner;

import Dominio.Medicamentos;
import Implementacion.LogicaMetodos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lectura = null;

		String nombreMedi;
		String marcaMedi;
		float precioMedi;
		boolean recetaMedi;

		Medicamentos medicamento = null;

		int menuPrinc;

		LogicaMetodos imp = new LogicaMetodos();

		do {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1---Alta");
			System.out.println("2--Mostrar");
			System.out.println("3---Buscar");
			System.out.println("4---Editar");
			System.out.println("5---Eliminar");
			System.out.println("6--Salir");

			lectura = new Scanner(System.in);
			menuPrinc = lectura.nextInt();

			switch (menuPrinc) {
			case 1:
				try {
					System.out.println("Ingrese el nombre");
					lectura = new Scanner(System.in);
					nombreMedi = lectura.nextLine();

					System.out.println("Ingrese la marca");
					lectura = new Scanner(System.in);
					marcaMedi = lectura.nextLine();

					System.out.println("Ingrese precio");
					lectura = new Scanner(System.in);
					precioMedi = lectura.nextFloat();

					System.out.println("Es con receta medica? true o false");
					lectura = new Scanner(System.in);
					recetaMedi = lectura.nextBoolean();

					// Crear el objeto
					medicamento = new Medicamentos(nombreMedi, marcaMedi, precioMedi, recetaMedi);

					// Agregar al hashMap
					imp.guardar(medicamento);
					System.out.println("Se guardo correctamente");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar");
				}
				break;
			case 2:
				imp.mostrar();
				break;
			case 3:
				System.out.println("Ingrese el nombre del medicamento a buscar");
				lectura = new Scanner(System.in);
				nombreMedi = lectura.nextLine();

				// Buscar
				medicamento = imp.buscar(nombreMedi);
				System.out.println(medicamento);
				break;
			case 4:
				System.out.println("Ingrese el nombre del medicamento a editar");
				lectura = new Scanner(System.in);
				nombreMedi = lectura.nextLine();

				// Buscar
				medicamento = imp.buscar(nombreMedi);
				System.out.println("Se encontro el medicamento " + medicamento.getNombre());

				// Editar --- Receta
				System.out.println("Ingrese si lleva receta o no: true o false");
				lectura = new Scanner(System.in);
				recetaMedi = lectura.nextBoolean();

				// Actualizar el objeto
				medicamento.setReceta(recetaMedi);

				// Actualizar en el hashMap
				imp.editar(medicamento);
				System.out.println("Se edito");

				break;
			case 5:
				System.out.println("Ingrese el nombre");
				lectura = new Scanner(System.in);
				nombreMedi = lectura.nextLine();

				// Eliminar
				imp.eliminar(nombreMedi);
				System.out.println("Se elimino con exito");
				break;
			case 6:
				break;
			}

		} while (menuPrinc < 6);

	}

}
