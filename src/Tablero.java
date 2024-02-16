import personajes.*;

import java.util.Random;


public class Tablero {
    Personaje[][] tablero = new Personaje[8][8];

    /**
     * Metodo para mostrar el tablero.
     * Costa de dos for encadenado, para hacer las filas y las columnas.
     */
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
    /**
     * Metodo para buscar personajes.
     * @param filaOrigen trae un número entero desde el main para buscar en las filas.
     * @param columnaOrigen  trae un número entero desde el main para buscar en las columnas.
     * @return Devuelve un valor boolean depende si la casilla del tablero es diferente de null.
     * */
    public boolean buscaPerso (int filaOrigen, int columnaOrigen){
        if (tablero[filaOrigen][columnaOrigen] != null){
            return true;
        }
        return false;
    }
    /**
     * Metodo para mover las fichas del tablero.
     * @param filaOrigen Trae un número entero desde el main para igualar las filas.
     * @param columnaOrigen Trae un número entero desde el main para igualar las columnas.
     * @param filaNueva Trae un número entero desde el main.
     * @param columnaNueva Trae un número entero desde el main.
     * Hace el igualado de las filas y columnas y luego las antiguas las pone a null para borrar el personaje de la casilla antigua.
     * */
    public void mover(int filaOrigen,int columnaOrigen ,int filaNueva, int columnaNueva) {
        tablero[filaNueva][columnaNueva] = tablero[filaOrigen][columnaOrigen];
        tablero [filaOrigen] [columnaOrigen] = null;
    }
    /**
     * Metodo para poner el personaje en el tablero.
     * @param ejeFila Trae un número entero para definir la fila de la array para seleccionar personaje.
     * @param ejeColumn Trae un número entero para definir la columna de la array para seleccionar el personaje.
     * @param perso Trae del main el personaje ya creado.
     *
     * */
    public void setPersoTablero (int ejeFila,int ejeColumn, Personaje perso){
        tablero[ejeFila][ejeColumn] = perso;
    }
    /**
     * Metodo para que los personajes ataquen
     * @param filaOrigen Trae un número entero para buscar el personaje que se dispone a atacar.
     * @param columnaOrigen Trae un número entero para buscar el personaje que se dispone a atacar.
     * @param filaAtaque Trae un número entero para el objetivo a atacar.
     * @param columnaAtaque Trae un número entero para el objetivo a atacar.
     * Se generan dos números random para el ataque y defensa, luego se guardan en una variable la resta para ver cuando le resta en el ataque. Si llega a ser
     * número negativo la vida del personaje la pone a 0.
     * */
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
    /**
     * Metodo para curar el personaje
     * @param filaOrigen Trae un número entero para buscar tu personaje.
     * @param columnaOrigen Trae un número entero para buscar tu personaje.
     * Hace un número rándom para ver cuanto se cura el personaje.
     * */
    public void curar (int filaOrigen, int columnaOrigen) {
        int curacion;
        Random random = new Random();
        curacion = random.nextInt(0,tablero[filaOrigen][columnaOrigen].getVidaMaxima());
        tablero[filaOrigen][columnaOrigen].setCura(curacion);
        System.out.println("Tu personaje se curo " + curacion + "\n Ahora tiene un total de vida: " + tablero[filaOrigen][columnaOrigen].getVida());
    }
    /**
     * Método para devolver un número para medir en rango de la columna para el ataque.
     * @param columnaOrigen Trae un numero para calcular el rango de ataque.
     * @param columnaAtaque Trae un número para calcular el rango de ataque.
     * @return Retorna un int para poder atacar.
     * */
    public int compruebaRangoColumna ( int columnaOrigen, int columnaAtaque ){
        int rangoColmuna = columnaAtaque - columnaOrigen;
        return rangoColmuna;
    }
    /**
     * Método para devolver un número para medir el rango de la fila para el ataque
     * @param filaOrigen Trae un numero para calcular el rango de ataque.
     * @param filaAtaque Trae un número para calcular el rango de ataque.
     * @return Retorna un int para poder atacar.
     * */
    public int compruebaRangoFila( int filaOrigen, int filaAtaque ){
        int rangoFila = filaAtaque - filaOrigen;
        return rangoFila;
    }
}
