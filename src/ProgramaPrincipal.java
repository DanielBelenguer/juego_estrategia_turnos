import personajes.*;
import tablero.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramaPrincipal {
    static void enterContinuar () {
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("Presiona ENTER para continuar...");
            scan.nextLine();
        }
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
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
                        enterContinuar();
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

    }
}



