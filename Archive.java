package highscores;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Archive {
	//la clase escribe en un archivo
	
	private Path path;
	private BufferedWriter file;
	PrintWriter printer;
	
	//una vez que declaré las variables que voy a usar, hago el constructor de Archivos
	
	Archive(String rutaDestino){ //le doy la ruta donde quiero que cree el archivo
		
		path=Paths.get(rutaDestino);
		file=null;
	
	
		try{
			file=Files.newBufferedWriter(path, StandardCharsets.UTF_8); //viene con el parámetro options pero se puede omitir
			printer= new PrintWriter(file);
		}
		catch(IOException e){
			e.printStackTrace(); //muestra en consola cuál fue el error y en qué linea
		}
	}
	
	//es un @Override ?????? 
	public void print (String unString){
		
		printer.print(unString);
	}
	
	public void println (String unString){
		
		printer.println(unString);
		
	}
	public void close(){
		printer.close();
	
		try{
			file.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void escribirArchivo(String cadena){ //ok
		
		this.println(cadena);	
		
	}
	
	public void muestraContenido(String archivo) throws FileNotFoundException, IOException { //ok
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
        	
            System.out.println(cadena);
        }
        b.close();
    }
 
	public void rellenar(){                     //RELLENO CON 10 FILAS DE CEROS MI ARCHIVO
		for(int i=0; i<10; i++){
			this.escribirArchivo("0");
		}
	}
	
	public int[] guardarCampos(String nombreArchivo) throws FileNotFoundException, IOException{
		
		//GUARDO LOS PUNTAJES QUE ESTAN EN EL ARREGLO 
		int[] arrayScores= new int[10];
		
		String cadena;
        FileReader f = new FileReader(nombreArchivo);
        BufferedReader b = new BufferedReader(f);
        
        int iterador=0;
        
        while((cadena = b.readLine())!=null && iterador<10) {  //ITERO HASTA EL ULTIMO PUNTAJE DEL ARCHIVO
        	
        	
        	//LO GUARDO EN EL ARREGLO DE SCORES
        	arrayScores[iterador]=Integer.parseInt(cadena);
        	iterador++;
        }
        b.close();
        
        return arrayScores;
	}
	
	public void addScore(int score) throws FileNotFoundException, IOException{
		
		//PRIMERO GUARDO LOS SCORES QUE HAY EN EL ARCHIVO EN UN ARREGLO
		
		int[] rankingActual= this.guardarCampos("archivoScores.txt");
		
		//UNA VEZ GUARDADOS, REDIMENSIONO EL ARREGLO CON UN ELEMENTO MÁS
		
		int[] rankingNuevo= new int[rankingActual.length+1];
		
		//AHORA CARGO TODOS LOS PUNTAJES QUE ESTÁN EL ARCHIVO, ME QUEDA VACIO EL ULTIMO LUGAR
		
		
		
		for(int j=0; j<rankingActual.length; j++){ 
			//NO LLEGO HASTA EL FINAL XQ EL ULTIMO LUGAR ES PARA EL PUNTAJE A AGREGAR
			rankingNuevo[j]=rankingActual[j];
					
		}
		//AHORA AGREGO EL NUEVO PUNTAJE EN LA ULTIMA POSICION
		rankingNuevo[rankingNuevo.length]=score;
		
		//ORDENO EL ARREGLO CON EL NUEVO SCORE
		quicksort(rankingNuevo,0,rankingNuevo.length);
		
		//AHORA GUARDO LOS TOP 10 DE > A < EN EL ARCHIVO
		guardarEnReverso(rankingNuevo,"archivoScores.txt"); //GUARDAR ES EL QUE CREA EL NUEVO ARCHIVO QUE PISA AL OTRO
		
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
	
	
	
	
	
	
	
	
	
	
	
}


