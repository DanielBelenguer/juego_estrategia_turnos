import personajes.*;
import java.lang.*;

public class ProgramaPrincipal {
    public static void main(String[] args) {

       /* Tablero tablero = new Tablero();
        tablero.mostrarTablero();*/


        Personaje sol1 = new Soldado();
        sol1.info();
        System.out.println("_____________________");
        Personaje lan1 = new Lancero();
        lan1.info();
        System.out.println("_____________________");
        Personaje cab1 = new Caballero();
        cab1.info();
        System.out.println("_____________________");
        Personaje arq1 = new Arquero();
        arq1.info();
        System.out.println("_____________________");
    }
}
