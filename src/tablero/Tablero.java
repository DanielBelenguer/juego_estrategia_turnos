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
            System.out.print(filas+"  ");
            for ( int columnas = 0; columnas < tablero[filas].length; columnas++) {
                if (tablero[filas][columnas]==null){
                    System.out.print("|       ");
                }else {
                    System.out.print("|" + tablero[filas][columnas].getInfoPerso() + "  ");
                }
            }
            System.out.println("|");
        }
    }

    public Personaje setPosicionTablero (Personaje pers){
        tablero[pers.getEjeFila()][pers.getEjeColumna()] = pers;
        return pers;
    }
}

