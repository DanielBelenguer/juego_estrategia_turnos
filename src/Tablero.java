import personajes.*;

import java.util.Random;


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
            for ( int columnas = 0; columnas < tablero.length; columnas++) {
                if (tablero[filas][columnas]==null){
                    System.out.print("|       ");
                }else {

                    System.out.print("|" + tablero[filas][columnas].getInfoPerso() + "  ");
                }
            }
            System.out.println("|");
        }
    }

    public boolean buscaPerso (int filaOrigen, int columnaOrigen){
        if (tablero[filaOrigen][columnaOrigen] != null){
            return true;
        }
        return false;
    }
    public void mover(int filaOrigen,int columnaOrigen ,int filaNueva, int columnaNueva) {
        tablero[filaNueva][columnaNueva] = tablero[filaOrigen][columnaOrigen];
        tablero [filaOrigen] [columnaOrigen] = null;
    }

    public void setPersoTablero (int ejeFila,int ejeColumn, Personaje perso){
        tablero[ejeFila][ejeColumn] = perso;
    }

    public void atacar (int filaOrigen, int columnaOrigen, int filaAtaque, int columnaAtaque) {
        int randomAtaque,randomDefensa,resultAtaque;
        Random random = new Random();
        randomAtaque = random.nextInt(tablero[filaOrigen][columnaOrigen].getAtaque()); // Generamos un número random para el ataque de este personaje
        randomDefensa = random.nextInt(tablero[filaAtaque][columnaAtaque].getDefensa()); // Generamos otro random para la defensa del otro personaje
        resultAtaque = randomAtaque - randomDefensa;
        System.out.println("Defensa " + randomDefensa);
        System.out.println("Ataque " + randomAtaque);
        if (resultAtaque <=0){
            resultAtaque = 0;
        }
        tablero[filaAtaque][columnaAtaque].setVida(resultAtaque);

    }
    public void curar (int filaOrigen, int columnaOrigen) {
        int curacion;
        Random random = new Random();
        curacion = random.nextInt(0,tablero[filaOrigen][columnaOrigen].getVidaMaxima());
            tablero[filaOrigen][columnaOrigen].setCura(curacion);
        System.out.println("Tu personaje se curo " + curacion + "\n Ahora tiene un total de vida: " + tablero[filaOrigen][columnaOrigen].getVida());
    }

}
