package personajes;

import java.util.Random;
import java.util.Scanner;

public class Lancero extends Personaje{
    private boolean existePersonaje = false;

    public Lancero() {
        coste = 5;ataque = 5;defensa = 5;vida = 10;radio = 2;
    }
    @Override
    public String toString () {
        return "Lancero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
    @Override
    public void atacar(Personaje perso){
        int randomDefensa , randomAtaque, resultAtaque;

        Random random = new Random();
        randomAtaque = random.nextInt(ataque); // Generamos un número random para el ataque de este personaje
        randomDefensa = random.nextInt(perso.getDefensa()); // Generamos otro random para la defensa del otro personaje
        resultAtaque = randomDefensa - randomAtaque;
        perso.setVida(resultAtaque);
    }
    @Override
    public void mover(Personaje[][] posiciones) {
        //setEjeFila(ejeFila);
        //setEjeColumna(ejeColumna);
        Scanner sc = new Scanner(System.in);

        //en caso de que la posicion este ocupada volvemos a preguntar las posiciones
        while (existePersonaje == true) {
            System.out.println("Indique las coordenadas del personaje a mover, introduce la fila: ");
            int filaOrigen = sc.nextInt();
            System.out.println("Ahora indique la columna: ");
            int columnaOrigen = sc.nextInt();
            //Comprobamos que el personaje existe
            if (posiciones[filaOrigen][columnaOrigen] != null) {
                System.out.println("Indique las nuevas coordenadas del personaje, introduce fila");
                int filaNueva = sc.nextInt();
                System.out.println("Ahora indique la columna");
                int columnaNueva = sc.nextInt();
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
        return "L" + "(" + vida + ")";
    }
}
