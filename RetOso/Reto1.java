package RetOso;

import java.io.IOException;
import java.util.Scanner;

public class Reto1 {
    public static void exec() throws IOException{
        Scanner entrada = new Scanner (System.in);


        // se pueden poner varias declaraciones del mismo tipo en la misma linea
        // ejemplo float peso, altura;
        float Peso;
        float Altura;
        int Edad;
        char Genero;

        System.out.println("Bienvenid@ a farmacias Causa");
        System.out.println("Ingrese lo que quiere hacer: \n A. Cálculo de masa corporal (índice de masa corporal) \n B. Cálculo de masa corporal magra \n C. Cálculo de metabolismo basal (GEB)");
        
        //lo ideal es que no se use el .nextline porque puede mandar errores, es mejor usar .next
        //El .nextLine es para strings pero tambien existe .nextInt o .nextFloat etc.
        //En el charAt se le pone 0 para que te devuelva el primer caracter del string
        switch (entrada.nextLine().charAt(0)) {

            case 'A' -> {

                System.out.println("Ingrese el peso del cliente en KG: ");
                Peso = entrada.nextFloat(); 

                System.out.println("Ingrese la altura del cliente en CM: ");
                Altura = entrada.nextFloat();
                
                float IMC = (float)(Peso / Math.pow((Altura / 100), 2));

                System.out.println("El Indice de masa corporal del cliente es de: " + IMC );

                if (IMC < 19.0){
                    System.out.println("peso bajo");
                }else if ( IMC >= 19.0 && IMC < 25.0 ){
                    System.out.println("Peso normal");
                }else if ( IMC >= 25.0 && IMC < 30.0 ){
                    System.out.println("Sobrepeso");
                }else if ( IMC >= 30.0 && IMC < 35.0 ){
                    System.out.println("Obesidad leve");
                }else if ( IMC >= 35.0 && IMC < 40 ){
                    System.out.println("Obesidad media");
                }else{
                    System.out.println("Obesidad morbida");
                }
            }

            case 'B' -> {

                float MCM;

                System.out.println("Ingrese el peso del cliente en KG: ");
                Peso = entrada.nextFloat(); 

                System.out.println("Ingrese la altura del cliente en CM: ");
                Altura = entrada.nextFloat();

                System.out.println("Ingrese el genero del cliente(Masculino o Femenino): ");
                Genero = entrada.next().charAt(0);

                if (Genero == 'M' || Genero == 'm'){
                    MCM = (float)((1.1 * Peso) - (128 * (Math.pow(Peso, 2) / Math.pow(Altura, 2) )));
                }else {
                    MCM = (float)((1.07 * Peso) - (148 * (Math.pow(Peso, 2) / Math.pow(Altura, 2) )));
                }

                System.out.println("La masa corporal magra del cliente es de: " + MCM);
            }

            case 'C'-> {
                float GEB;
                
                System.out.println("Ingrese el peso del cliente en KG: ");
                Peso = entrada.nextFloat(); 

                System.out.println("Ingrese la altura del cliente en CM: ");
                Altura = entrada.nextFloat();

                System.out.println("Ingrese la edad del cliente: ");
                Edad = (int)entrada.nextFloat();

                System.out.println("Ingrese el genero del cliente(Masculino o Femenino): ");
                Genero = entrada.next().charAt(0);

                if (Genero == 'M' || Genero == 'm'){
                    GEB = (float)(66.5 + (13.75 * Peso)+(5.003*Altura)-(6.775*Edad));
                }else {
                    GEB = (float)(65.51 + (9.563 * Peso)+(1.85*Altura)-(4.676*Edad));
                }

                System.out.println("El metabolismo basal del cliente es de: " + GEB);
            }

            default -> System.out.println("Seleccione una opcion valida");
        }
    }
}
