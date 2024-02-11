package personajes;

import java.util.Random;
import java.util.Scanner;

public class Arquero extends Personaje {
    private boolean existePersonaje = false;
    public Arquero(int ejeFila, int ejeColumna) {
        coste = 15; ataque = 10;defensa = 5;vida = 10;radio = 3;this.ejeFila=ejeFila;this.ejeColumna=ejeColumna;
    }
    @Override
    public String toString () {
        return "Arquero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
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
    public void mover(Personaje[][] posiciones){
        //setEjeFila(ejeFila);
        //setEjeColumna(ejeColumna);
        Scanner sc = new Scanner(System.in);

        //en caso de que la posicion este ocupada volvemos a preguntar las posiciones
        while (existePersonaje=true) {
            System.out.println("Indique las coordenadas del personaje a mover, introduce la fila: ");
            int filaOrigen = sc.nextInt();
            System.out.println("Ahora indique la columna: ");
            int columnaOrigen = sc.nextInt();
            //recorremos el array posiciones para saber si la posicion esta libre
            for(int filaTablero = 0;filaTablero<posiciones.length;filaTablero++){
                for(int columnaTablero = 0;columnaTablero<posiciones.length;columnaTablero++){
                    if(posiciones[filaOrigen][columnaOrigen]!=null){
                        this.existePersonaje = true;
                    }else {
                        System.out.println("no existe el personaje");
                    }
                }
            }
        }
        //si la posición está ocupada, solicitamos los datos de las nuevas coordenadas y comprobamos que no esten ocupadas
        while (existePersonaje==true){
            System.out.println("Indique las nuevas coordenadas del personaje, introduce fila");
            int filaNueva=sc.nextInt();
            System.out.println("Ahora indique la columna");
            int columnaNueva=sc.nextInt();
            //recorremos el tablero para ver si la nueva posición está ocupada
            for(int filaTablero=0;filaTablero<posiciones.length;filaTablero++){
                for(int columnaTablero=0;columnaTablero<posiciones.length;columnaTablero++){
                    if(posiciones[filaNueva][columnaNueva]==null){
                        posiciones[ejeFila][ejeColumna]=posiciones[filaNueva][columnaNueva];
                    }else {System.out.println("posicion ocupada");}
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
    public int getEjeFila() {
        return ejeFila;
    }
    @Override
    public void setEjeFila(int ejeFila) {
        if (ejeFila >= 0 && ejeFila <=7 ){
            this.ejeFila=ejeFila;
        }
    }
    @Override
    public int getEjeColumna() {
        return ejeColumna;
    }
    @Override
    public void setEjeColumna(int ejeColumna) {
        if (ejeColumna >= 0 && ejeColumna <=7 ){
            this.ejeColumna=ejeColumna;
        }
    }
    @Override
    public  String getInfoPerso(){
        return "A" + "(" + vida + ")";
    }

}
