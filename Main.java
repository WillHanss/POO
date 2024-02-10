import RetOso.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) throws IOException{
        Scanner Selecction = new Scanner(System.in);
        int actividad;
        System.out.println("Ingresa el numero de actividad a que quieres ejecutar: ");
        actividad = Selecction.nextInt();

        switch(actividad){
            case 1->{
                Reto1.exec();
            }
            case 2->{
                Reto2.exec();
            }
            default->{
                System.out.println("Pon un numero valido");
            } 
        }
        Selecction.close();
    }
}