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

       // Creacion de los ejercitos
       crearEjercito(ejerAzul);
       crearEjercito(ejerRojo);

   }
   static void crearEjercito(Personaje [] listapers){
        int costeTotal=0,posicion=0,opt;
        Scanner lector = new Scanner(System.in);

       while (costeTotal < 50) {
           System.out.println("Tienes un total de " + costeTotal + " de puntos por gastar.\n" +
           "1 - Soldado " + listapers[posicion].getCoste() + "2 - Caballero " + listapers[posicion].getCoste()
           + "3 - Arquero " + listapers[posicion].getCoste() + "4 - Lancero " + listapers[posicion].getCoste() +
           "Elige personaje para crear ");

            opt=lector.nextInt();
            switch (opt){
                case 1:
                    listapers[posicion] = new Soldado();
                    costeTotal += listapers[posicion].getCoste();
                    posicion++;
                    break;
                case 2:
                    listapers[posicion] = new Caballero();
                    costeTotal += listapers[posicion].getCoste();
                    posicion++;
                    break;
                case 3:
                    listapers[posicion] = new Arquero();
                    costeTotal += listapers[posicion].getCoste();
                    posicion++;
                    break;
                case 4:
                    listapers[posicion] = new Lancero();
                    costeTotal += listapers[posicion].getCoste();
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