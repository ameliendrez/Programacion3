package practico5;

public class TableroMagico {
	
	private int tablero[][]; //Tablero a completar
	private int cantidadFC; //Cantidad de Filas y Columnas (n * n)
	private int maxNum; //Numero maximo a utilizar (k)
	private int sumaSolucion; // Valor que debe dar la suma de cada fila y de cada columna (S)
	private int sumaFilas[]; // Sumatoria por cada fila
	private int sumaColumnas[]; //Sumatoria por cada columna 
	private boolean numeroUsado[]; // Indica si el numero esta disponible o si ya se utilizo
	
	public TableroMagico(int cantidadFC, int maxNum, int sumaSolucion){ 
		
		//Inicializo las variables
		this.cantidadFC = cantidadFC;
		this.tablero = new int [cantidadFC][cantidadFC];
		this.sumaFilas = new int [cantidadFC];
		this.sumaColumnas = new int [cantidadFC];
		this.numeroUsado = new boolean [maxNum + 1];
		this.sumaSolucion = sumaSolucion;
		this.maxNum = maxNum;
	}
	
	private void mostrarTablero() { 
		
		//Imprimo la matriz del tablero. 
		for(int i = 0; i < cantidadFC; i++) {
			for(int j = 0; j < cantidadFC; j++) {
				System.out.print(tablero[i][j] + " - ");
			}
			System.out.println("");
		}
	}
	
	private boolean haySolucion() { 
		
		//Comprueba si la sumatoria de las columnas y de las filas es igual al valor buscado
		for(int i = 0; i < cantidadFC; i++) {
			if(sumaFilas[i] != sumaSolucion || sumaColumnas[i] != sumaSolucion)
				return false;			
		}
		return true;
	}
	
	private boolean numeroFactible(int fila, int columna, int nuevoNumero)
	{
		
		if((sumaFilas[fila] + nuevoNumero > sumaSolucion ||
				sumaColumnas[columna] + nuevoNumero > sumaSolucion)) 
			
			//Compruebo que, si la suma es mayor al valor buscado, se debe buscar otro numero para insertar
			return false;
		
		//Si no es mayor, por el momento se puede utilizar
		return true;
	}
	
	public boolean buscarSolucion() {
		
		//Método que invoca al backtracking
		//Primero comprueba que k sea menor a (n*n), si no es asi, no se puede resolver.
		if (maxNum <= cantidadFC * cantidadFC){
			System.out.println("El numero maximo a utilizar debe ser mayor a: " + (cantidadFC * cantidadFC));
			return false;
		}
		//En caso de no haber error, invoca al backtracking
		else
			return backTrackingTablero(0, 0);
	}

	public boolean backTrackingTablero(int fila, int columna){
		
		boolean solucion = false;

		if(haySolucion()) { // Consulta si existe una solucion.
			mostrarTablero(); //En caso de existir, imprime la matriz con los valores correspondientes.
			solucion = true;
			return solucion; //Finaliza la busqueda.
		}
		//En caso de no existir solucion
		boolean elimineNumero = false;
		int numeroSeleccionado = 1;
		
		//Comprueba que no haya encontrado solucion, que no se hayan descartado numeros, 
		//y que el numero seleccionado se menor al maximo numero posible de utilizar
		while(!solucion && !elimineNumero && numeroSeleccionado <= maxNum) {
			if(!numeroUsado[numeroSeleccionado]) { //Si el numero no esta utilizado
				if(!numeroFactible(fila, columna, numeroSeleccionado))
					elimineNumero = true; 	// si se pasa del numero solucion (s) corta la ejecucion
				else { 						//Sino, recorre filas y columnas agregando numeros
					int prox_col = 0; 
					int prox_fila = 0;
					
					//----------ACA SE ESTA SALIENDO DEL ARREGLO -------------//
					//----------no se si fila o columna----------------------//
					
					prox_fila = (columna == cantidadFC - 1) ? (fila + 1) : fila;
					prox_col = (columna == cantidadFC - 1) ? 0 : (columna + 1);
					
					numeroUsado[numeroSeleccionado] = true;
					tablero[fila][columna] = numeroSeleccionado;
					sumaFilas[fila] += numeroSeleccionado;
					sumaColumnas[columna] += numeroSeleccionado;
					//Luego de insertar un numero, realiza la recursion (backtracking)
					solucion = (prox_fila == cantidadFC || prox_col == cantidadFC) ? false : backTrackingTablero(prox_fila, prox_col); 
					//Luego vuelvo a la situacion inicial
					numeroUsado[numeroSeleccionado] = false;
					tablero[fila][columna] = 0;
					sumaFilas[fila] -= numeroSeleccionado;
					sumaColumnas[columna] -= numeroSeleccionado;
				}
			}
			numeroSeleccionado++; //Cuando finaliza con un numero, lo aumenta
		}
		return solucion; //Al finalizar, si encontro una solucion retorna true, sino false.
	}
}
