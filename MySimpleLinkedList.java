package practico1;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Object> {
	
	protected Node first;
	protected Node last;
	protected int nodeCount;
	protected Node cursor;
	
	
	public class MyIterator implements Iterator<Object> {

		private Node cursor;
		
		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Object next() {
			Node tmp = cursor;
			cursor = cursor.getNext();
			return tmp.getInfo();
		}
		
		public void remove(){
			//Método para implementar	
		}
		
		private MyIterator (Node first){
			this.cursor = first;
		}
	}

	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.nodeCount = 0;
	}
	public void insert(Object o) {
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		this.first = tmp;
		if (last == null) {
			last = first;
		}
		nodeCount++;
	}
	
	public void insertLast(Object o) {
		Node tmp = new Node(o,null);
		if (last!=null) {
			last.setNext(tmp);
			last = tmp;
		}else {
			last = tmp;
			first = tmp;
		}
		this.nodeCount++;	
	}

	public Object extract() {
		if (!this.isEmpty()) {
			Node retorno = first;
			this.first = first.getNext();
			this.nodeCount--;
			return retorno;
		}
		return null;
	}

	public boolean isEmpty() {
		return first == null;
	}
	public int size() { 
		return this.nodeCount;
	}
	
	public void resetCursor(){
		this.cursor = first;
	}
	
	public Object get(){
		Object element = cursor.getInfo();
		this.cursor = cursor.getNext();
		return element;
	}
	
	public boolean cursorHasNext(){
		return cursor != null;
	}
	
	@Override
	public MyIterator iterator() {
		return new MyIterator(first);
	}
	
	public void insertOrganized(Object elemento) {
		
		if (this.isEmpty() || (int)first.getInfo() > (int)elemento) {
			this.insert(elemento);
		}
		else {
			System.out.println("Entra en insertar");
			cursor = first;
			while (cursor.getNext() != null  && cursor.getInfo() != elemento && cursor.getNext().getInfo() != elemento) {
				if ((int)cursor.getNext().getInfo() > (int)elemento) {
					Node tmp = new Node(elemento, cursor.getNext());
					cursor.setNext(tmp);
					cursor = cursor.getNext();
					nodeCount++;
					break;
				}
			}
			if ((cursor.getNext() == null && cursor.getInfo()!=elemento)) {
				this.insertLast(elemento);
			}
		}
	}
	
	public MySimpleLinkedList combinarListasDesordenas(MySimpleLinkedList lista) {

		MySimpleLinkedList newList = new MySimpleLinkedList();		
		MyIterator elemL1 = this.iterator();

		while (elemL1.hasNext()) {
			int valorE1 = (int)elemL1.next();
			MyIterator elemL2 = lista.iterator();

			while (elemL2.hasNext()) {	
				int valorE2 = (int)elemL2.next();
				if (valorE1 == valorE2) {
					newList.insertOrganized(valorE1);
					break;
				}
			}
		}
		return newList;
	}
	
	public MySimpleLinkedList combinarListasOrdenadas (MySimpleLinkedList lista) {
		
		MySimpleLinkedList newList = new MySimpleLinkedList();		
		MyIterator elemL1 = this.iterator();

		while (elemL1.hasNext()) {
			int valorE1 = (int)elemL1.next();
			MyIterator elemL2 = lista.iterator();

			while (elemL2.hasNext()) {	
				int valorE2 = (int)elemL2.next();
				if (valorE1 == valorE2) {
					newList.insertLast(valorE1);
					break;
				}
				else if (valorE1 < valorE2) {
					break;
				}
			}
		}
		return newList;
	}
	
	public Node getFirst() {
		return first;	
	}	
	

	public void printElement(int n) {
		System.out.println(this.search(n).getInfo());;
	}

	public Node search(int n) {
		if (n < this.nodeCount) {

			Node actual = first;
			int iterador = 0;

			while (iterador < n) {
				actual = actual.getNext();
				iterador++;
			}
			return actual;
		}
		return null;
	}
}
