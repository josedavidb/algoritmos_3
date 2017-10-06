import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ReadWriteFile {

  public static void readWriteFile(String fileNameIn, String fileNameOut)
                     throws IOException, FileNotFoundException{
    int n = 0;
    Scanner scan = new Scanner(new File(fileNameIn));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileNameOut)));
    String[] tok;

    while (scan.hasNext())
    {
      scan.next();
      out.print("e\t");
      n = scan.nextInt();
      out.print(n+"\t");
      n = scan.nextInt();
      out.print(n+"\n");
    }
    scan.close();
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
