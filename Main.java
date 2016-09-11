package highscores;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//creo un nuevo archivo
		Archive archivoNuevo= new Archive("/home/army/Documentos/PROGRA 3 WORKSPACE/Manejo de archivos/archivoScores.txt");
		
		
		//ALGUNAS PRUEBAS:
		
		//voy a escribir en miarchivo
		//archivoNuevo.escribirArchivo("Puntaje 1"); // ok
//		archivoNuevo.escribirArchivo("Puntaje 2"); // ok
//		archivoNuevo.escribirArchivo("Puntaje 3"); // ok
		
		
		//archivoNuevo.close(); //antes no mostraba en pantalla xq necesitaba cerrar el archivo antes de mostrar su contenido
		
		//archivoNuevo.muestraContenido("archivoScores.txt"); 
		//muestra lo que hay escrito en el archivo por consola
		
		
		//archivoNuevo.close();
		
		//---------------------------------------------------------------------------------------------------------
		
		
		// RELLENO MI ARCHIVO CON 10 FILAS DE CEROS QUE SERÁN EL RANKING
		
		///archivoNuevo.rellenar();
		//archivoNuevo.close();
		
		//archivoNuevo.close();
		
		//archivoNuevo.escribirArchivo("77554");//ok
		///archivoNuevo.close();
		
		//archivoNuevo.muestraContenido("archivoScores.txt");
		
		///int[] puntajesArray=archivoNuevo.guardarCampos("archivoScores.txt");
		///imprimirArray(puntajesArray);
		
		//AHORA QUE TENGO GUARDADOS LOS PUNTAJES EN UN ARREGLO COMO ENTEROS TENGO QUE AGREGAR NUEVOS PUNTAJES DE A UNO
		
		
		
		
		///archivoNuevo.close();
		
		//-------------------------------------------------------------------------------
		
		//PRUEBO EL QUICKSORT      
		
//		int[] numeros={12, 4, 15,3, 25,7,2,10};
//		imprimirArray(numeros);
//		System.out.println("");
//		quicksort(numeros,0,7); //OK SI LE DOY LA PRIMERA Y ULTIMA POS COMO IZQ Y DER COMO PARAMETROS
//		imprimirArray(numeros);
		
		//----------------------------------------------------------------------------------
		
		
		//PRUEBO EL GUARDAR EN REVERSO 
//		guardarEnReverso(numeros,"archivoScores.txt"); //OK
//		
//		archivoNuevo.close();
//		
		
		//------------------------------------------------------------------------------------
		
		//PRUEBO ADD SCORE
		
		//RELLENO CON 10 SCORES AL AZAR
		
		archivoNuevo.escribirArchivo("12");
		archivoNuevo.escribirArchivo("4");
		archivoNuevo.escribirArchivo("3");
		archivoNuevo.escribirArchivo("25");
		archivoNuevo.escribirArchivo("7");
		archivoNuevo.escribirArchivo("2");
		archivoNuevo.escribirArchivo("10");
		archivoNuevo.escribirArchivo("1");
		archivoNuevo.escribirArchivo("120");
		archivoNuevo.escribirArchivo("5");
		
		
		archivoNuevo.close();
		//LOS GUARDÓ DESORDENADOS 
		archivoNuevo.addScore(13);
		
		archivoNuevo.close();
		
		
		
		
		
		
		
		
	}
	public static void imprimirArray(int[] arreglo){ //OK
		
		for(int i=0; i<arreglo.length; i++){
			
			System.out.println("["+ arreglo[i]+"]");
		}
		
	}
	
	public static void quicksort(int A[], int izq, int der) { //OK

		  int pivote=A[izq]; // tomamos primer elemento como pivote
		  int i=izq; // i realiza la búsqueda de izquierda a derecha
		  int j=der; // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while(i<j){            // mientras no se crucen las búsquedas
		     while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
		     while(A[j]>pivote) j--;         // busca elemento menor que pivote
		     if (i<j) {                      // si no se han cruzado                      
		         aux= A[i];                  // los intercambia
		         A[i]=A[j];
		         A[j]=aux;
		     }
		   }
		   A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
		   A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
		   if(izq<j-1)
		      quicksort(A,izq,j-1); // ordenamos subarray izquierdo
		   if(j+1 <der)
		      quicksort(A,j+1,der); // ordenamos subarray derecho
		}

	public static void guardarEnReverso(int[] arr, String rutaArchivo){
	//UNA VEZ ORDENADO DE < A > POR QUICKSORT, LO GUARDO AL REVES, LOS PRIMEROS 10
	//SOBREESCRIBO EL ARCHIVO, PARA QUE PISE LO QUE HABÍA ESCRITO EN EL
	
	Archive otroArchivo= new Archive(rutaArchivo);
	
	
	for(int i=arr.length; i>=1;i--){
	
		otroArchivo.escribirArchivo(""+i);
	}
	otroArchivo.close();
	
	}	
	

}
