package practico2;

import java.util.ArrayList;

public class ABB {
	
	private Integer info;
	private ABB der;
	private ABB izq;
	
	
	private int altura;
	private int alturaIzq;
	private int alturaDer;

	public ABB() {
		this.info = null;
		this.der = null;
		this.izq = null;
		this.altura = 0;
		this.alturaIzq = 0;
		this.alturaDer = 0;
	}
	
	public boolean hasElem(Integer elementoBuscado) {

		if (this.getInfo().equals(elementoBuscado)) 
			return true; 
		
		else if ((this.getInfo()).compareTo(elementoBuscado) > 0) 
			if (!this.isEmptyIzq()) 
				return this.getIzq().hasElem(elementoBuscado);
			else 
				return false;
		
		else 
			if (!this.isEmptyDer()) 
				return this.getDer().hasElem(elementoBuscado);
			else 
				return false;
	}

	public void insert(Integer nuevoElemento) {
		if (this.getInfo() != null && !hasElem(nuevoElemento)) {
			if ((this.getInfo()).compareTo(nuevoElemento) > 0) {
				if (this.isEmptyIzq()) {
					ABB nodoIzq = new ABB();
					nodoIzq.insert(nuevoElemento);
					this.izq = nodoIzq;
				} 
				else {
					this.getIzq().insert(nuevoElemento);
				}
			} 
			else {
				if (this.isEmptyDer()) {
					ABB nodoDer = new ABB();
					nodoDer.insert(nuevoElemento);
					this.der = nodoDer;
				} 
				else {
					this.getDer().insert(nuevoElemento);
				}
			}
		}
		else {
			if (this.getInfo() == null) 
				this.info = nuevoElemento;
			else 
				System.out.println ("El numero " + nuevoElemento +" ya existe. No se puede agregar nuevamente");
		}
	}

	public void addNodoDer(ABB nodoDer) {
		this.der = nodoDer;
	}

	public void addNodoIzq(ABB nodoIzq) {
		this.izq = nodoIzq;
	}

	public Integer getInfo() {
		return this.info;
	}

	public ABB getIzq() {
		return this.izq;
	}

	public ABB getDer() {
		return this.der;
	}

	public boolean isEmpty() {
		return this.getInfo() == 0;
	}

	public boolean isEmptyDer() {
		return this.der == null;
	}

	public boolean isEmptyIzq() {
		return this.izq == null;
	}
	
	public void printInOrder(){
		if (!this.isEmptyIzq()) 
			this.getIzq().printInOrder();
		System.out.print(this.getInfo() + " - ");
		if (!this.isEmptyDer()) 
			this.getDer().printInOrder();
	}
	
	public void printPreOrder(){
		System.out.print(this.getInfo() + " - ");

		if (!this.isEmptyIzq()) 
			this.getIzq().printPreOrder();
		
		if (!this.isEmptyDer()) 
			this.getDer().printPreOrder();
	}
	
	public void printPosOrder(){
		if (!this.isEmptyIzq()) 
			this.getIzq().printPosOrder();
		
		if (!this.isEmptyDer()) 
			this.getDer().printPosOrder();
		
		System.out.print(this.getInfo() + " - ");
	}
	
	public Integer getMaxElem(){
		if (!this.isEmptyDer()) 
			return this.getDer().getMaxElem();

		else
			return this.getInfo();
	}
	
	public int getHeight() {
	
		if (this.isEmptyDer() && this.isEmptyIzq()) 
			return 0;
		if (!this.isEmptyIzq()) 
			alturaIzq = this.getIzq().getHeight() + 1;
		if (!this.isEmptyDer()) 
			alturaDer = this.getDer().getHeight() + 1;

		altura = (alturaDer > alturaIzq) ? alturaDer : alturaIzq; 
		return altura;
	}
	
	public void setIzq(ABB izq) {
		this.izq = izq;
	}
	
	public void setDer(ABB der) {
		this.der = der;
	}
	
	private ABB obtenerMasIzquierdo(){
		ABB masIzquierdo = null;
			if (this.getIzq().isEmptyIzq() && this.getIzq().isEmptyDer()) {
				masIzquierdo = this.getIzq();
				this.izq = null;
			}
			else if (this.getIzq().isEmptyIzq() && !this.getIzq().isEmptyDer()) {
				ABB tmpDer = this.getIzq().getDer();
				masIzquierdo = this.getIzq();
				this.izq = tmpDer;
			}
			else if (!this.getIzq().isEmptyIzq()) {
				masIzquierdo = this.getIzq().obtenerMasDerecho();
			}
		
		return masIzquierdo;
	}
	
	private ABB obtenerMasDerecho(){ 
		ABB masDerecho = null;
			if (this.getDer().isEmptyIzq() && this.getDer().isEmptyDer()) {
				masDerecho = this.getDer();
				this.der = null;
			}
			else if (!this.getDer().isEmptyIzq() && this.getDer().isEmptyDer()) {
				ABB tmpIzq = this.getDer().getIzq();
				masDerecho = this.getDer();
				this.der = tmpIzq;
			}
			else if (!this.getDer().isEmptyDer()) {
				masDerecho = this.getDer().obtenerMasIzquierdo();
			}
		
		return masDerecho;
	}
	
	public ArrayList<Integer> getFrontera (){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		if (!this.isEmptyIzq()) 
			lista.addAll(this.getIzq().getFrontera());
		
		if (!this.isEmptyDer()) 
			lista.addAll(this.getDer().getFrontera());

		if (this.isEmptyDer() && this.isEmptyIzq()) 
			lista.add(this.getInfo());

		return lista;
	}
	
//	public boolean delete (Integer borrarElem) {
//		
//		// Si es mayor lo busca a la derecha
//		if (borrarElem > this.getInfo() && !this.isEmptyDer()) {
//			//Si es igual al primer elemento se fija los adyacentes
//			if (borrarElem == this.getDer().getInfo()) {
//				if (this.getDer().isEmptyIzq() && this.getDer().isEmptyDer()) {
//					this.setDer(null);
//				}
//				else if (this.getDer().isEmptyIzq() && !this.getDer().isEmptyDer()) {
//					this.setDer(this.getDer().getDer());
//				}
//				else if (!this.getDer().isEmptyIzq()){
//					ABB tmp = this.obtenerMasIzquierdo();
//					this.getDer().setDer(tmp);
//				}
//			return true;
//			}
//			//Si no realiza una recursion con el proximo.
//			else {
//				return this.getDer().delete(borrarElem);
//			}
//		}
//		// Si es menor lo busca a la izquierda y hace lo mismo que el anterior
//		else if (borrarElem < this.getInfo() && !this.isEmptyIzq()){
//			
//			if (borrarElem == this.getIzq().getInfo()) {
//				if (this.getIzq().isEmptyIzq() && this.getIzq().isEmptyDer()) {
//					this.setIzq(null);
//				}
//				else if (!this.getIzq().isEmptyIzq() && this.getIzq().isEmptyDer()) {
//					this.setIzq(this.getIzq().getIzq());
//				}
//				else if (!this.getIzq().isEmptyDer()){
//					ABB tmp = this.obtenerMasDerecho();
//					this.getIzq().setIzq(tmp);
//				}
//			return true;
//			}
//			
//			else {
//				return this.getIzq().delete(borrarElem);
//			}
//		}
//		else {
//			//Significa que es la raiz
//			ABB tmp = null;
//
//			if (!this.isEmptyDer()) {
//				if (this.getDer().isEmptyIzq()){
//					tmp = this.getDer().getDer();
//					this.setDer(tmp);
//					this.info = tmp.getInfo();
//				}
//				else if (!this.getDer().isEmptyIzq()) {
//					tmp = this.getDer().obtenerMasIzquierdo();
//					this.info = tmp.getInfo();
//				}
//				else if (this.isEmptyDer() && !this.isEmptyIzq()) {
//					tmp = this.getIzq().obtenerMasDerecho();
//					this.info = tmp.getInfo();
//				}
//				
//				System.out.println("La nueva raiz es: " + this.getInfo());
//			}
//		}
//		return false;
//	}
	

	
	//METODOS QUE FALTAN IMPLEMENTAR
	
//	boolean delete(Object), 
	
//	List getLongestBranch(),  camino de nodos mas largo
			
//	List getElemAtLevel(i) una lista de elementos en ese nivel
}
