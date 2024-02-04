import personajes.*;
import tablero.Tablero;
import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;
public class ProgramaPrincipal {
   public static void main(String[] args) {
       Scanner lector = new Scanner(System.in);
       //Declaracion de variables
       int sumacoste=0,opt;
       Personaje [] ejerAzul = new Personaje[1];
       Personaje [] ejerRojo = new Personaje[1];
       //
       // creamos el tablero
       Tablero mapa = new Tablero();
       crearEjercito(ejerAzul);
       System.out.println(ejerAzul[2]);

   }
   static void crearEjercito(Personaje [] listapers){
        int costeTotal=0,posicion=0,opt;
        Scanner lector = new Scanner(System.in);

       while (costeTotal < 50) {
            System.out.println("""
                    Tienes un total de 50 puntos para gastar. \n 
                    1 - Soldado (10)\n
                    2 - Caballero (25)\n
                    3 - Arquero (5)\n
                    4 - Lancero (19)\n
                    elije tus personajes:\n
                    """);
            opt=lector.nextInt();
            switch (opt){
                case 1:
                    Soldado sol = new Soldado();
                    listapers[posicion] = sol;
                    costeTotal += sol.getCoste();
                    posicion++;
                    break;
                case 2:
                    Caballero cab = new Caballero();
                    listapers[posicion] = cab;
                    costeTotal += cab.getCoste();
                    posicion++;
                    break;
                case 3:
                    Arquero arq = new Arquero();
                    costeTotal += arq.getCoste();
                    listapers[posicion] = arq;
                    posicion++;
                    break;
                case 4:
                    Lancero lan = new Lancero();
                    costeTotal += lan.getCoste();
                    listapers[posicion] = lan;
                    posicion++;
                    break;
                default:
                    System.out.println("Introduce opcion valida.");
            }
            if (costeTotal < 50) {
                //Crea una copia con longitud + 1 y la asigna a la variable array
                listapers = Arrays.copyOf(listapers, listapers.length+1);
                listapers[listapers.length-1] = null;
            }

       }
   }
}