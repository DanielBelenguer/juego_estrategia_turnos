import personajes.*;
import tablero.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        // creamos el tablero
        Tablero tablero = new Tablero();
        Ejercito ejerAzul = new Ejercito();
        Ejercito ejerRojo = new Ejercito();

        //Creamos ejercito azul
        tablero.mostrarTablero();
        System.out.println("Comienza el equipo azul creando su ejercito");

        ejerAzul.crearEjercito("azul", tablero);

        tablero.mostrarTablero();

        ejerAzul.getPerso().mover(tablero.posicionesTablero());
        //tablero.actualizarTablero(ejerAzul.getPerso());
        tablero.mostrarTablero();





        //Creamos ejercito rojo
        /*System.out.println("Ahora le toca al equipo rojo crear su ejercito");

        tablero.actualizarTablero(ejerRojo.crearEjercito("rojo"));
        tablero.mostrarTablero();*/

    }



}
