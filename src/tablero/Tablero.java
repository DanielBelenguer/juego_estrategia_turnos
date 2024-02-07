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
            for ( int columnas = 0; columnas < tablero[filas].length; columnas++) {
                if (tablero[filas][columnas]==null){
                    System.out.print("|       ");
                }else {
                    System.out.print("|" + tablero[filas][columnas].getInfoMapa() + "  ");
                }
            }
            System.out.println("|");
        }
    }
    public Personaje crearEjercito(int opt){

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
    public boolean setpersonajeMapaAzul (Personaje perso,int fila,int columna){
        if ((fila >= 0 && fila <=7 )&& (columna >=0 && columna <=7)){
            if (tablero[fila][columna] == null){
                if (columna == 6 || columna == 7){
                    tablero[fila][columna] = perso;
                    return true;
                }else {
                    System.out.println("La columna no es correcta, debes elegir la 6 o la 7");
                    return false;
                }
            }else {
                System.out.println("La posición elegida está ocupada");
                return false;
            }
        }else {
            System.out.println("Los valores introducidos no son correctos");
            return false;
        }
    }
    public boolean setpersonajeMapaRojo (Personaje perso,int fila,int columna){
        if ((fila >= 0 && fila <=7 )&& (columna >=0 && columna <=7)){
            if (tablero[fila][columna] == null){
                if (columna == 0 || columna == 1){
                    tablero[fila][columna] = perso;
                    return true;
                }else {
                    System.out.println("La columna no es correcta, debes elegir la 0 o la 1");
                    return false;
                }
            }else {
                System.out.println("La posición elegida está ocupada");
                return false;
            }
        }else {
            System.out.println("Los valores introducidos no son correctos");
            return false;
        }
    }
}