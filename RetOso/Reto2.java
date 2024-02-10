package RetOso;
import java.io.IOException;
import java.util.Scanner;

public class Reto2 {
    Scanner entrada = new Scanner (System.in);
    public static void exec() throws IOException{
        Scanner entrada = new Scanner (System.in);
        int Trabajo;

        System.out.println("Que trabajo quiere realizar? \n1. Promedio de calificaciones \n2.Compra y venta");
        Trabajo = entrada.nextInt();

        switch(Trabajo){
            case 1->{
                System.out.println("--------------------------- \n- Promedio calificaciones - \n---------------------------");
                ShortCuts.Promedios();
            }
            case 2->{
                System.out.println("------------------ \n- Compra y Venta - \n------------------");
                Reto2 RTD = new Reto2();
                ShortCuts programa = RTD.new ShortCuts("admin", "admin");
                programa.Inicio();
            }
            default->{
                System.out.println("Favor de ingresar un trabajo valido");
            } 
        }
    }
    private class ShortCuts{
        private String Contrasena, Usuario;
        private int Ventas, Compras, Operaciones;
        private double Ingresos, Egresos, Balance;

        public static void Promedios(){
            Scanner entrada = new Scanner (System.in);
            int suma = 0;
            float promedio = 0;
    
            System.out.println("Ingrese la cantidad de calificaciones a promediar: ");
            int NoCalif = entrada.nextInt();

            System.out.println("Ingrese las calificaciones (1-100): ");
    
            for(int i=1; i<=NoCalif; i++){

                int calificaciones = entrada.nextInt();
                suma = suma + calificaciones;
    
            }
            promedio = promedio + suma / NoCalif;
    
            System.out.println("El promedio es de " + promedio);

            if (promedio >= 70){
                System.out.println("Felicidades, aprovaste!");
            }else{
                System.out.println("Hechale mas ganas la proxima, reprobaste");
            }
        }

        public ShortCuts(String User, String Pass){
            this.Usuario   = User;
            this.Contrasena= Pass;
            this.Balance   = 0; 
            this.Ingresos  = 0;
            this.Egresos   = 0;
        }

        public void login(){
            String tempUsuario = ".";
            String tempPassword = ".";

            System.out.println("Favor de ingresar un usuario y contaseña");

            while(tempUsuario.equals(this.Usuario) == false && tempPassword.equals(this.Contrasena) == false){
                System.out.println("Usuario : ");
                tempUsuario = entrada.next();
                System.out.println("Contraseña : ");
                tempPassword = entrada.next();

                if (tempUsuario.equals(this.Usuario) == true && tempPassword.equals(this.Contrasena) == true){
                System.out.println("Ha iniciado sesion correctamente");
                break;
                }else{
                System.out.println("Los datos son incorrectos, intente de nuevo");
                }
            }
        }

        public static double precioCompra (){
            Scanner entrada = new Scanner (System.in);
            double precioCompra;
    
            System.out.println("¿Que tipo de papel desea comprar?");
            System.out.println("1. Papel prensa (10.00$) \n2. Papel bond (15.00$) \n3. Papel registro (20.00$) \n 4. otro");
            int Tpapel = entrada.nextInt();
            switch (Tpapel) {
                case 1->{
                    precioCompra = 10.00;
                }
                case 2->{
                    precioCompra = 15.00;
                }
                case 3->{
                    precioCompra = 20.00;
                }
                case 4->{
                    System.out.println("Ingrece el precio del papel");
                    precioCompra = entrada.nextFloat();
                }
                default ->{
                    System.out.println("no se ha encontrado el producto");
                    precioCompra = 0;
                }   
            }
            return precioCompra;
        }

        public static double precioVenta (){
            Scanner entrada = new Scanner (System.in);
            double precioVenta;
    
            System.out.println("¿Que tipo de papel desea Vender?");
            System.out.println("1. Papel prensa (15.00$) \n2. Papel bond (20.00$) \n3. Papel registro (25.00$) \n 4. otro");
            int Tpapel = entrada.nextInt();
            switch (Tpapel) {
                case 1->{
                    precioVenta = 10.00;
                }
                case 2->{
                    precioVenta = 15.00;
                }
                case 3->{
                    precioVenta = 20.00;
                }
                case 4->{
                    System.out.println("Ingrece el precio del papel");
                    precioVenta = entrada.nextFloat();
                }
                default ->{
                    System.out.println("no se ha encontrado el producto");
                    precioVenta = 0;
                }   
            }
            return precioVenta;
        }

        public void Inicio(){
            System.out.println("- Papeleria XPress -");
            login();
            int procesos = 0;
            while (procesos != 4){
                System.out.println("-------------------- \n¿Que proceso desea realizar?");
                System.out.println("1. Comprar cajas de papel \n2. Vender Cajas de papel \n3. Mostrar Reporte \n4. Salir del programa");
                procesos = entrada.nextInt();

                switch (procesos){
                    case  1->{ //Compra cajas de papel
                        int Cajas;
                        double precioCaja = 0;
                        double totalCajas = 0;

                        System.out.println("- Compra de papel -");
                        System.out.println("¿Cuantas cajas de papel se van a comprar?");
                        Cajas = entrada.nextInt();
                        precioCaja = precioCompra();
                        totalCajas = Cajas*precioCaja;

                        System.out.println("La compra realizada por " + Cajas + "al precio de " + precioCaja + "es igual a" + totalCajas);
                        Compras = Compras++;
                        Egresos = Egresos + totalCajas;

                    }case 2->{ //Venta cajas de papel
                        int Cajas;
                        double precioCaja = 0;
                        double totalCajas = 0;

                        System.out.println("- Venta de papel -");
                        System.out.println("¿Cuantas cajas de papel se van a vender?");
                        Cajas = entrada.nextInt();
                        precioCaja = precioVenta();
                        totalCajas = Cajas*precioCaja;

                        System.out.println("La venta realizada por " + Cajas + "al precio de " + precioCaja + "es igual a" + totalCajas);
                        Ventas = Ventas++;
                        Ingresos = Ingresos + totalCajas;
                    }case 3->{ //Reporte momentaneo
                        Balance = Ingresos-Egresos;
                        Operaciones = Ventas+Compras;
                        System.out.println("- Reporte -");
                        System.out.println("El total de ventas fue de: " + Ventas);
                        System.out.println("El total de Compras fue de: " + Compras);
                        System.out.println("El total de Ingresos fue de: $" + (Ingresos));
                        System.out.println("El total de Egresos fue de: $" + (Egresos));
                        System.out.println("El total en la caja es de: $" + Balance);
                        System.out.println("El total de operaciones ha sido de: " + Operaciones);
                        
                    }case 4->{ //Salida
                        Balance = Ingresos-Egresos;
                        Operaciones = Ventas+Compras;
                        System.out.println("- Saliendo del programa -");
                        System.out.println("El total de ventas fue de: " + Ventas);
                        System.out.println("El total de Compras fue de: " + Compras);
                        System.out.println("El total de Ingresos fue de: $" + (Ingresos));
                        System.out.println("El total de Egresos fue de: $" + (Egresos));
                        System.out.println("El total en la caja es de: $" + Balance);
                        System.out.println("El total de operaciones ha sido de: " + Operaciones);
                        System.out.println("- Gracias por confiar en nosotros -");
                    }default->{
                        System.out.println("Favor de seleccionar una opcion valida");
                    }
                }
            }
        }
    }
}