import java.util.Arrays;
public class Ruta{

  	public static void main (String[] args){

  	}
	private double[][] grafo;
	
	public Ruta(int n){
		this.grafo = new double[n][n];
		Grafo();
	}

	private void Grafo(){

		for (int i = 0; i < grafo.length; i++){
			for (int j = 0; j < grafo.length ; j++) {
				if (i == j) {
					grafo[i][j] = 0;
					
				}
				else {
					grafo[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}
	}

	public void Adyacente(int ini, int fin, double tamaño){
		grafo[ini][fin] = tamaño;
	}

	public double[][] warshall(){
		double [][] camino;
		int n = this.grafo.length;
		camino = Arrays.copyOf(this.grafo,n);
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n ; j++ ) {
				for (int k = 0; k < n  ; j++) {
					if (camino[j][i] == camino[i][k]) {
						camino [j][k] = 1; 
					}
				}
				
			}
		}
		return camino;
	}

}

