package tablero;

import personajes.*;

import java.util.Arrays;
import java.util.Scanner;

public class Tablero {
    Personaje[][] tablero = new Personaje[8][8];


    public void mostrarTablero (){

        System.out.print("       ");  //ocupamos el espacio en blanco de la izquierda
        for ( int i = 0; i < 8; i++) {

            System.out.print(i+"       "); //rellenamos los espacios restantes con su numero correspondiente

        }
        System.out.println();
        for ( int filas= 0; filas < tablero.length; filas++) {

            System.out.print(filas+"  ");     //

            for ( int columnas = -1; columnas < tablero[filas].length; columnas++) {

                System.out.print("|       ");


            }
            System.out.println();
        }
    }
    public Personaje crearEjercito(int opt){
            System.out.println("Tienes un total de 50 puntos por gastar.\n" +
                    "1 - Soldado 10 puntos\n2 - Caballero  25 puntos\n3 - Arquero 15 puntos\n4 - Lancero 5 puntos" +
                    "\nElige personaje para crear ");

            switch (opt){
                case 1:
                    Personaje sol = new Soldado();
                    return sol;
                case 2:
                    Personaje cab = new Caballero();
                    return cab;

                case 3:
                    Personaje arq = new Arquero();
                    return arq;
                case 4:
                    Personaje lan = new Lancero();
                    return lan;
                default:
                    System.out.println("Introduce opción válida.");
            }
            return null;
    }

}

