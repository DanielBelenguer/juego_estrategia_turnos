import personajes.*;
import tablero.Tablero;
import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;
public class ProgramaPrincipal {
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //Declaracion de variables
        Personaje [] ejerAzul = new Personaje[1];
        Personaje [] ejerRojo = new Personaje[1];
        // creamos el tablero
        Tablero mapa = new Tablero();
        // Creamos ejercito Azul
        int sumacoste=0,contador=0;
        while (sumacoste < 50) {
            System.out.println("""
                    Tienes 50 puntos para gastar
                    1-Soldado 10 puntos, 2-Caballero 25, 3-Arquero 15,4-Lancero 5
                    Seleccione personajes: """);
            ejerAzul[contador] = mapa.crearEjercito(lector.nextInt());
            sumacoste+=ejerAzul[contador].getCoste();
            contador++;
            if (sumacoste < 50) {
                //Crea una copia con longitud + 1 y la asigna a la variable array
                ejerAzul = Arrays.copyOf(ejerAzul, ejerAzul.length+1);
                ejerAzul[ejerAzul.length-1] = null;
            }
        }
        // Creamos ejercito Rojo
        sumacoste=0;contador=0;
        while (sumacoste < 50) {
            System.out.println("Elije un personaje: ");
            ejerRojo[contador] = mapa.crearEjercito(lector.nextInt());
            sumacoste+=ejerRojo[contador].getCoste();
            contador++;

            if (sumacoste < 50){
                //Crea una copia con longitud + 1 y la asigna a la variable array
                ejerRojo = Arrays.copyOf(ejerRojo,ejerRojo.length+1);
                ejerRojo[ejerRojo.length-1] = null;
            }
        }
        for (Personaje per: ejerAzul){
            System.out.println(per);
        }
        for (Personaje per :ejerRojo){
            System.out.println(per);
        }

   }

}