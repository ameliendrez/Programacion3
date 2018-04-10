package practico1;
import practico1.MySimpleLinkedList.MyIterator;

public class PracticoMain {

	public static void main(String[] args) {
		
		//Creo las Listas Ordenadas 1 y 2
		
		MySimpleLinkedList listaOrdenada1 = new MySimpleLinkedList();
		MySimpleLinkedList listaOrdenada2 = new MySimpleLinkedList();

		for (int i = 0; i < 15; i++){
			
			// La lista ordenada 1 es de 0 a 15. 
			listaOrdenada1.insertLast(i);
			
			// La lista ordenada 2 son los divisibles por dos entre el 0 y el 15
			
			if ((i%2) == 0) {
				listaOrdenada2.insertLast(i);
			}
		}
		
		System.out.println ("Imprimo la lista ordenada 1:");

		//Creo iterador de la Lista Ordenada 1 e imprimo
		
		MyIterator iteradorLO1 = listaOrdenada1.iterator();

		while (iteradorLO1.hasNext()) {
			System.out.print (iteradorLO1.next() + " - ");
		}
		System.out.println ("");
		System.out.println ("");
		System.out.println ("Imprimo la lista ordenada 2:");
		
		//Creo iterador de la Lista Ordenada 2 e imprimo

		MyIterator iteradorLO2 = listaOrdenada2.iterator();

		while (iteradorLO2.hasNext()) {
			System.out.print (iteradorLO2.next() + " - ");
		}
		System.out.println ("");

		
		//Creo la Lista ordenada 3
		
		MySimpleLinkedList listaOrdenada3 = new MySimpleLinkedList();
		
		// Combino las listas ordenadas 1 y 2
		listaOrdenada3 = listaOrdenada1.combinarListasOrdenadas(listaOrdenada2);
		
		System.out.println ("");
		System.out.println ("Imprimo la lista ordenada 3:");

		//Creo iterador de la Lista Ordenada 3 e imprimo

		MyIterator iteradorLO3 = listaOrdenada3.iterator();

		while (iteradorLO3.hasNext()) {
			System.out.print (iteradorLO3.next() + " - ");
		}
		

		//Creo las listas desordenadas 1 y 2
		
		MySimpleLinkedList listaDesordenada1 = new MySimpleLinkedList();
		MySimpleLinkedList listaDesordenada2 = new MySimpleLinkedList();

		
		for (int i = 0; i < 10; i++){
			
			// Completo las listas desordenadas con valores entre el 1 y el 25 
			listaDesordenada1.insertLast((int)(Math.random() * 25) + 1);
			listaDesordenada2.insertLast((int)(Math.random() * 25) + 1);
		}

		System.out.println ("");
		System.out.println ("");
		System.out.println ("Imprimo la lista desordenada 1:");

		//Creo iterador de la Lista Desordenada 1 e imprimo

		MyIterator iteradorLD1 = listaDesordenada1.iterator();

		while (iteradorLD1.hasNext()) {
			System.out.print (iteradorLD1.next() + " - ");
		}
		
		System.out.println ("");
		System.out.println ("");
		System.out.println ("Imprimo la lista desordenada 2:");

		//Creo iterador de la Lista Desordenada 2 e imprimo

		MyIterator iteradorLD2 = listaDesordenada2.iterator();

		while (iteradorLD2.hasNext()) {
			System.out.print (iteradorLD2.next() + " - ");
		}
		
		//Creo la lista desordenada 3
		MySimpleLinkedList listaDesordenada3 = new MySimpleLinkedList();
		
		//Combino las listas desordenadas 1 y 2
		listaDesordenada3 = listaDesordenada1.combinarListasDesordenas(listaDesordenada2);
		
		System.out.println ("");
		System.out.println ("");
		System.out.println ("Imprimo la lista desordenada 2:");

		//Creo iterador de la Lista Desordenada 3 e imprimo

		MyIterator iteradorLD3 = listaDesordenada3.iterator();

		while (iteradorLD3.hasNext()) {
			System.out.print (iteradorLD3.next() + " - ");
		}
	}
}
