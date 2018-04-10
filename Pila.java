package practico1;

public class Pila {
	
	private MySimpleLinkedList datos;
	public Pila() {
		this.datos = new MySimpleLinkedList();
	}
	public void addElemnt(Object o) {
		this.datos.insert(o);
	}
	public Object removeElements() {
		return this.datos.extract();
	}
	public boolean pilaEmpty() {
		return this.datos.isEmpty();
	}
	public Object limit() {
		Object retorno = this.datos.extract();
		this.datos.insert(retorno);
		return retorno;
	}
}
