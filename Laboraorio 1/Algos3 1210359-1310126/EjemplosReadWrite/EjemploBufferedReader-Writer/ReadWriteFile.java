import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ReadWriteFile {

  public static void readWriteFile(String fileNameIn, String fileNameOut)
      throws IOException {
    int i, n = 0;
    BufferedReader in = new BufferedReader(new FileReader(fileNameIn));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileNameOut)));
    String s;
    String[] tok;

    while ((s = in.readLine()) != null ){
      tok = s.split("\\b\\s");
      if (tok[0].charAt(0) == 'e') {
        for(i = 0; i < tok.length-1; i++)
          out.print(tok[i]+"\t");
        out.println(tok[tok.length-1]);
      }
    }
    in.close();
    out.close();
  }

  public static void main(String[] args){
    if (args.length != 2) {
      System.out.println("Error en los argumentos del programa\nEjecutar:");
      System.out.println("java LeerEscribirArchivo <nombreArchivoEntrada> <nombreArchivoSalida>");
      System.exit(1);
    }
    System.out.println( "\n*** Archivo de entrada: " + args[0]);
    System.out.println( "\n*** Archivo de salida: " + args[1]);
    try{
      readWriteFile(args[0], args[1]);
    } catch(IOException e){
      System.err.println("Error en la lectura/escritura del archivo");
      e.printStackTrace();
    }
  }
}
