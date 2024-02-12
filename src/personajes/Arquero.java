package personajes;

import tablero.Tablero;

import java.util.Random;
import java.util.Scanner;

public class Arquero extends Personaje {
    private boolean existePersonaje = false;
    Scanner lector = new Scanner(System.in);

    public Arquero() {
        coste = 15; ataque = 10;defensa = 5;vida = 10;radio = 3;
    }
    @Override
    public String toString () {
        return "Arquero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
    @Override
    public void atacar(Tablero tablero){
        int atacaFila, atacaColumna, randomDefensa,randomAtaque, resultAtaque;
        System.out.println("A que personaje quieres atacar");
        System.out.println("Introduzca Fila: ");
        atacaFila = lector.nextInt();
        System.out.println("Introduzca Columna: ");
        atacaColumna = lector.nextInt();
        if (tablero.posicionesTablero()[atacaFila][atacaColumna] != null){
            Random random = new Random();
            randomAtaque = random.nextInt(ataque); // Generamos un número random para el ataque de este personaje
            randomDefensa = random.nextInt(tablero.posicionesTablero()[atacaFila][atacaColumna].getDefensa()); // Generamos otro random para la defensa del otro personaje
            resultAtaque = randomDefensa - randomAtaque;
            tablero.posicionesTablero()[atacaFila][atacaColumna].setVida(resultAtaque);
        }
    }
    @Override
    public void mover(Personaje[][] posiciones) {
        //setEjeFila(ejeFila);
        //setEjeColumna(ejeColumna);

        //en caso de que la posicion este ocupada volvemos a preguntar las posiciones
        while (existePersonaje == true) {
            System.out.println("Indique las coordenadas del personaje a mover, introduce la fila: ");
            int filaOrigen = lector.nextInt();
            System.out.println("Ahora indique la columna: ");
            int columnaOrigen = lector.nextInt();
            //Comprobamos que el personaje existe
            if (posiciones[filaOrigen][columnaOrigen] != null) {
                System.out.println("Indique las nuevas coordenadas del personaje, introduce fila");
                int filaNueva = lector.nextInt();
                System.out.println("Ahora indique la columna");
                int columnaNueva = lector.nextInt();
                //recorremos el tablero para ver si la nueva posición está ocupada

                if (posiciones[filaNueva][columnaNueva] == null) {

                    posiciones[filaOrigen][columnaOrigen] = posiciones[filaNueva][columnaNueva];
                } else {
                    System.out.println("La posicion está ocupada, por favor elija de nuevo posicion");
                }

            }

        }
    }
    @Override
    public void curar(){
        int curacion;
        Random random = new Random();
        curacion = random.nextInt(0,10);
        if (vida < 10){
            vida+=curacion;
        } else if (vida > 10) {
            vida = 10;
        }
        System.out.println("Tu personaje se curo" + curacion + "\n Ahora tiene un total de vida: " + vida);
    }
    public int getCoste() {
        return coste;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getDefensa(){
        return defensa;
    }
    public int getVida(){
        return vida;
    }
    @Override
    public int setVida(int restaAtaque) {
        if (restaAtaque <= 0){
            System.out.println("La fuerza del ataque fue demasiado baja y falla el ataque " + restaAtaque);
        }else {
            if (vida >= restaAtaque){
                System.out.println("Un ataque muy efectivo, le quita " + restaAtaque);
                return this.vida-=restaAtaque;
            }else {
                return 0;
            }
        }
        return 0;
    }
    public int getRadio(){
        return radio;
    }
    @Override
    public  String getInfoPerso(){
        return "A" + "(" + vida + ")";
    }

}
