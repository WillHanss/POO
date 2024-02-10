package RetOso;
import java.util.Scanner;
import java.io.IOException;
public class Reto3 {
   
    public static void exec () throws IOException {
        int procesos = 0;
        while (procesos != 4){
            System.out.println("----- Diccionario -----");
            System.out.println("1.Enlistar palabras del diccionario \n2.Buscar palabras del diccionario \n3.Detalle del diccionario \n4.Finalizar programa");
            procesos = entrada.nextInt();
            switch (procesos){
                case 1->{ //Enlistar palabras del diccionario
                    for (int i = 0; i < Palabras.length; i++) {
                        System.out.println(i + " - " + Palabras[i]);
                    }
                }
                case 2->{ //Buscar palabras del diccionario
                    boolean found = false;
                    System.out.println("Ingrese una palabra para buscar en el diccionario");
                    for (int i = 0; i < Palabras.length; i++) {
                        System.out.println((i+1) + " - " + Palabras[i]);
                    }
                    String palabra = entrada.next();
                    for (int i = 0; i < Palabras.length; i++) {
                        if (Palabras[i].equals(palabra)) {
                          System.out.println((i+1) + " - " + Palabras[i] + " : \n" + Significado[i]);
                          found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("No se encontro la palabra");
                    }
                }
                case 3->{  //Detalle del diccionario
                    System.out.println("Cantidad de palabras definicion en el diccionadio: " + Palabras.length);
                    for (int i = 0; i < Palabras.length; i++) {
                        int letrasPalabra = Palabras[i].length();
                        int letrasSignificado = Significado[i].length();
                        System.out.println((i+1) + " - " + Palabras[i] + " : " + letrasPalabra + " letras en total, cantidad de caracteres en el significado: " + letrasSignificado);
                    }
                }
                case 4->{ //Finalizar programa
                    System.out.println("----- Fin del programa v1.1 -----");
                    entrada.close();
                }
            }
        }
    }
    private static Scanner entrada = new Scanner(System.in);

    private static String[] Palabras    = new String[]{
        "Completar", "Tesoro", "Calendario", "Medicina", "Abrazadera", "Atmósfera", "Discoteca", "Batalla", "Payaso", "Almuerzo"
    };
        
    private static String[] Significado = new String[]{
        "Dar termino o conclicion a una cosa o a un proceso", 
        "Cantidad de dinero, valores u objeros preciosos reunidos y guardados", 
        "Sistema de representacion del paso de los dias agrupado en unidades superiores", 
        "Conocimientos y tecnicas aplicados a la prediccion, prevencion, diagnosticos y tratamientos de enfermedades", 
        "Pieza que se utiliza para sujetar algo, especificamente cables o tubos, ciñendolos o rodeandolos", 
        "Capa gaseosa que rodea la Tierra y a otros cuerpos celestes", 
        "Coleccion de discos musicales o sonoros", 
        "Combate o serie de combates de un ejercito con otro", 
        "Persona que hace reir con sus dichos o gestos", 
        "Comida del medio dia o primeras horas de la tarde"
    };     
}
