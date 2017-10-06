import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Grafo{

	private double matrizAdyacencia[][];
	private int numeroDeVertices;
	private int numeroDeAristas;
	private String linea;


	public Grafo(String archivo) throws IOException{
		/*Abrir y leer archivo txt, se va leyendo linea por linea*/
		BufferedReader in = new BufferedReader(new FileReader(archivo));
    	numeroDeVertices = Integer.parseInt(in.readLine());
		matrizAdyacencia = new double[numeroDeVertices][numeroDeVertices];
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

	public void mAdyacencia(){

		for (int i = 0; i < matrizAdyacencia.length; i++){
			for (int j = 0; j < matrizAdyacencia.length ; j++) {
				if (i == j) {
					matrizAdyacencia[i][j] = 0;
					
				}
				else {
					matrizAdyacencia[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}
	}

	}
