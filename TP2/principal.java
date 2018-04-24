package practico2;

import java.util.ArrayList;

public class principal {

	public static void main(String[] args) {
		
		ABB arbol = new ABB();
		
		for (int i = 0; i < 20; i++){
			
			arbol.insert((int)(Math.random() * 80) + 1);
		}
		
		System.out.println("");
		int elemento = (int)(Math.random() * 80) + 1;

		System.out.println(arbol.hasElem(elemento) ? "El arbol TIENE el numero " + elemento:"El arbol NO tiene el numero " + elemento);
		
		System.out.println("");
		
		System.out.print("Imprimo EN orden:  ");
		arbol.printInOrder();
		
		System.out.println("");

		System.out.print("Imprimo PRE orden: ");
		arbol.printPreOrder();
		
		System.out.println("");
		System.out.print("Imprimo POS orden: ");
		arbol.printPosOrder();
		
		System.out.println("");
		System.out.println("El numero mas grande es el " + arbol.getMaxElem());
		
		System.out.println("La altura es " + arbol.getHeight());
		
		ArrayList<Integer> hojas = arbol.getFrontera();
		
		System.out.print("Las hojas son: ");
		for (Integer hoja: hojas) {
			System.out.print(hoja + " - ");
		}
	}

}
