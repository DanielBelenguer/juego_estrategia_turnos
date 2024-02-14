import personajes.*;

import java.lang.*;
import java.util.Scanner;

public class ProgramaPrincipal {
    public enum Color {
        AZUL,ROJO
    }
    static int crearEjercito (int opt, Color color,int ejeFila,int ejeColumna, Tablero tablero){
        //Variables
        int minFila=0,maxFila=7,minColumna=10,maxColumna=236;
        if (color.equals(Color.AZUL)){
            minColumna = 6;
            maxColumna = 7;
        } else if (color.equals(Color.ROJO)) {
            minColumna = 0;
            maxColumna = 1;
        }
        switch (opt){
            case 1:
                //Comprobación de columna introducida es correcta
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje sol = new Soldado();
                    tablero.setPersoTablero(ejeFila,ejeColumna,sol);
                    System.out.println("personaje insertado");
                    return sol.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 2:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje cab = new Caballero();
                    tablero.setPersoTablero(ejeFila,ejeColumna,cab);
                    System.out.println("personaje insertado");
                    return cab.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 3:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje arq = new Arquero();
                    tablero.setPersoTablero(ejeFila,ejeColumna,arq);
                    System.out.println("personaje insertado");
                    return arq.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 4:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje lan = new Lancero();
                    tablero.setPersoTablero(ejeFila,ejeColumna,lan);
                    System.out.println("personaje insertado");
                    return lan.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            default:
                System.out.println("Elija una opcion válida");
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Tablero tablero = new Tablero();


        //Variables
        int opt,ejeFila,ejeColumna,sumacoste;
        Color color;
        //--------------------------

        // Creacion ejercito AZUL
        sumacoste=0;
        while (sumacoste < 50){
            System.out.println("Vamos a crear el ejercito Azul \n ¿Que quieres crear? \n 1 - Soldado\n 2 - Caballero\n 3 - Arquero\n 4 - Lancero");
            opt = lector.nextInt();
            color = Color.AZUL;
            tablero.mostrarTablero();
            System.out.println("Elija la fila donde quiera colocarlo: ");
            ejeFila = lector.nextInt();
            System.out.println("Elija la columna donde desea colocarlo: ");
            ejeColumna = lector.nextInt();
            sumacoste = sumacoste + crearEjercito(opt, color,ejeFila,ejeColumna,tablero);
            tablero.mostrarTablero();
        }

        int i= lector.nextInt();
        int ii= lector.nextInt();
        tablero.posicionesTablero();




       /*
        // Variable para el sistema de turnos
        boolean siono=true;
        // Creamos el tablero
        Tablero tablero = new Tablero();
        // Creamos los dos ejercitos
        Ejercito ejerAzul = new Ejercito();
        Ejercito ejerRojo = new Ejercito();

        //Creamos ejercito azul
        System.out.println("Comienza el equipo Azul creando su ejercito");
        tablero.mostrarTablero();
        ejerAzul.crearEjercito("azul", tablero);
        tablero.mostrarTablero();

        System.out.println("Turno de crear el ejercito del equipo Rojo");
        tablero.mostrarTablero();
        ejerRojo.crearEjercito("rojo",tablero);
        tablero.mostrarTablero();


        // Fin de bucle restando el conste del Personaje a sumaTotal (50)
        while (true){

            if (siono){
                System.out.println("Turno de equipo Azul\n Elija una accion: \n 1 - Mover \n 2 - Atacar \n 3 - Curar \n ----------------------------");
                int opt = lector.nextInt();
                System.out.println("Que personaje quiere realizar la accion: ");
                switch (opt) {
                    case 1:
                        tablero.mostrarTablero();
                        ejerAzul.getPerso().mover(tablero.posicionesTablero());
                        tablero.mostrarTablero();
                        break;
                    case 2:
                        tablero.mostrarTablero();
                        ejerAzul.getPerso().atacar(tablero);
                        break;
                    case 3:
                        ejerAzul.getPerso().curar();
                        System.out.println("Ahora el personaje tiene: " + ejerAzul.getPerso().getVida() + " Vida");
                        break;
                }
                System.out.println("Turno finalizado");
                siono=false;

            }else {
                System.out.println("Turno de equipo Rojo\n Elija una accion: \n 1 - Mover \n 2 - Atacar \n 3 - Curar \n ----------------------------");
                int opt = lector.nextInt();
                System.out.println("Que personaje quiere realizar la accion: ");
                switch (opt) {
                    case 1:
                        ejerRojo.getPerso().mover(tablero.posicionesTablero());
                        break;
                    case 2:
                        ejerRojo.getPerso().atacar(tablero);
                        break;
                    case 3:
                        ejerRojo.getPerso().curar();
                        break;
                }
                System.out.println("Turno finalizado");
                siono=true;
            }

            // Comprobar ejerAzul ejerRojo para salir del while
            //
            //
            //
        }
*/
    }
}



