package practico5;

public class Menu {

	public static void main(String[] args) {
		// Creo el tablero con: 
		// 1: Tamaño del tablero (n*n), 
		// 2: cantidad de numeros a usar (k) 
		// 3: resultado de suma filas y columnas (S)

		TableroMagico tablero = new TableroMagico(3, 12, 15);	
		
		//Le pregunto al tablero si existe una solucion.
		System.out.println(tablero.buscarSolucion() ? "Encontro una solucion": "No hay soluciones");	
	}
}
