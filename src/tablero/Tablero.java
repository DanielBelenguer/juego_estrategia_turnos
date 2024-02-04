package tablero;

import personajes.*;

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

    public void setpersonajestablero (Personaje personaje,int x,int y) {
            tablero[x][y] = personaje;
            mostrarTablero();
    }

    }

