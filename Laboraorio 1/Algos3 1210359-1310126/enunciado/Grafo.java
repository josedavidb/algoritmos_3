/*Laboratorio de Algoritmos y Estructuras 3
Laboratorio 1 
Jose Basanta 13-10125
Jesus Marcano 12-10359

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;

public class Grafo{

	private int matrizAdyacencia[][]; //Matriz de adyacencia asociada al grafo
	private int numeroDeVertices; //Numero de vertices del grafo
	private int numeroDeAristas; //Numero de aristas del grafo
	private String linea; //Lineas del archivo de texto


	public Grafo(String archivo) throws IOException{
		/*Abrir y leer archivo txt, se va leyendo linea por linea*/
		BufferedReader in = new BufferedReader(new FileReader(archivo));
    	numeroDeVertices = Integer.parseInt(in.readLine());
		matrizAdyacencia = new int[numeroDeVertices][numeroDeVertices];
    	numeroDeAristas = Integer.parseInt(in.readLine());
    	for (int p=0;p<numeroDeVertices;p++){
    		for(int q=0;q<numeroDeVertices;q++){
    			/*Se rellena toda la matriz de adyacencia con ceros*/
    			matrizAdyacencia[p][q] = 0;
    		}
    	}
    	for(int i=0;i<numeroDeAristas;i++){
    		/*Se cambia a 1 aquellos espacios de la matriz de adyacencias que indique el txt*/
    		linea = in.readLine();
    		matrizAdyacencia[Character.digit(linea.charAt(0),16)][Character.digit(linea.charAt(2),16)] = 1;
    }
		}


	public void imprimirGrafo(){
		/*Recorre matriz de adyacencia y lo imprime*/
		for(int i=0; i<matrizAdyacencia.length; i=i+1){
			for(int j=0; j<matrizAdyacencia.length; j=j+1){
			System.out.print(matrizAdyacencia[i][j]);
		}
		System.out.println();
	}
	}


	public int[][] warshall(){
		/*Algoritmo de Roy-warshall.
		Devuelve una matriz donde es 1 si existe camino entre dos vertices*/
	 int [][] camino;
	 	camino2 = new int[matrizAdyacencia.length][matrizAdyacencia.length];
		int n = matrizAdyacencia.length;
		camino = Arrays.copyOf(matrizAdyacencia,n);
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n ; j++ ) {
				for (int k = 0; k < n  ; k++) {
					if (camino[j][k]!=1) {
						camino [j][k] = camino[j][i] & camino[i][k];
					}
				}
				
			}
		}
		return camino;
	}

	
	

}
