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

            System.out.println("Tienes un total de 50 puntos y llevas gastados:" + " " + sumacoste + " " +
                "\nElige personaje para crear:" + "\n1 - Soldado 10 puntos\n2 - Caballero  25 puntos\n3 - Arquero 15 puntos\n4 - Lancero 5 puntos");

            ejerAzul[contador] = mapa.crearEjercito(lector.nextInt());
            sumacoste+=ejerAzul[contador].getCoste();
            contador++;
            if (sumacoste < 50) {
                //Crea una copia con longitud + 1 y la asigna a la variable array
                ejerAzul = Arrays.copyOf(ejerAzul, ejerAzul.length+1);
                ejerAzul[ejerAzul.length-1] = null;
            }
        }
        //Elección de posiciones jugador Azul
        mapa.mostrarTablero();
        System.out.println();
        System.out.println("Jugador azul elije tus posiciones (columna 6 y 7)");
        for (int i = 0; i < ejerAzul.length;) {
            System.out.println("Elija Fila y columna");
            if (mapa.setpersonajeMapaAzul(ejerAzul[i], lector.nextInt(), lector.nextInt())==true){
                i++;
            }
        }
        System.out.println("Esta es tu elección: ");
        mapa.mostrarTablero();


        // Creamos ejército Rojo
        sumacoste=0;contador=0;
        while (sumacoste < 50) {
            System.out.println("Tienes un total de 50 puntos y llevas gastados:" + " " + sumacoste + " " +
                    "\nElige personaje para crear:" + "\n1 - Soldado 10 puntos\n2 - Caballero  25 puntos\n3 - Arquero 15 puntos\n4 - Lancero 5 puntos");

            ejerRojo[contador] = mapa.crearEjercito(lector.nextInt());
            sumacoste+=ejerRojo[contador].getCoste();
            contador++;

            if (sumacoste < 50){
                //Crea una copia con longitud + 1 y la asigna a la variable array
                ejerRojo = Arrays.copyOf(ejerRojo,ejerRojo.length+1);
                ejerRojo[ejerRojo.length-1] = null;
            }
        }
        // Eleccion de posiciones jugador Rojo
        mapa.mostrarTablero();
        System.out.println();
        System.out.println("Jugador rojo elija tus posiciones (columna 0 y 1)");
        for (int i = 0; i < ejerRojo.length;) {
            System.out.println("Elija Fila y columna");
            if (mapa.setpersonajeMapaRojo(ejerRojo[i], lector.nextInt(), lector.nextInt())==true){
                i++;
            }
        }
        System.out.println("Esta es su elección: ");
        mapa.mostrarTablero();
    }
}
